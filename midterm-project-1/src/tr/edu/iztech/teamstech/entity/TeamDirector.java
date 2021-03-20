package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.data.DataInitializer;
import tr.edu.iztech.teamstech.data.DataSaver;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.PrivateChannel;
import tr.edu.iztech.teamstech.team.StandardChannel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.Academician;
import tr.edu.iztech.teamstech.user.Instructor;
import tr.edu.iztech.teamstech.user.TeachingAssistant;
import tr.edu.iztech.teamstech.user.User;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TeamDirector implements EntityDirector {
    private final List<Team> teams;
    private final List<User> users;
    private final List<Channel> channels;
    private User currentUser;
    private boolean unsafeMethodsEnabled;
    private DataSaver dataSaver;

    public TeamDirector() {
        this.teams = new LinkedList<>();
        this.users = new LinkedList<>();
        this.channels = new LinkedList<>();
        this.unsafeMethodsEnabled = false;
    }

    public TeamDirector(DataInitializer dataInitializer, DataSaver dataSaver) throws Exception {
        this();
        this.dataSaver = dataSaver;

        try {
            enableUnsafeMethods();
            dataInitializer.init(this);
        } finally {
            disableUnsafeMethods();
        }

    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void register(Entity entity) {
        if (entity instanceof User) {
            users.add((User) entity);
        } else if (entity instanceof Team) {
            teams.add((Team) entity);
        } else if (entity instanceof Channel) {
            channels.add((Channel) entity);
        }
    }

    @Override
    public Team createTeam(User sender, String teamId, String name, String defaultMeetingTime) throws UnauthorizedUserOperationException {
        if (sender.getId() != currentUser.getId())
            throw new UnauthorizedUserOperationException("Other user's methods cannot be executed.");

        if (!isInstructor(sender))
            throw new UnauthorizedUserOperationException("Only instructors can create a new team.");

        if (isTeamIdUsed(teamId))
            throw new IllegalStateException("The given team id is used.");

        Team team = new Team(this, teamId, name);
        register(team);

        enableUnsafeMethods();
        team.addTeamOwner(currentUser);
        currentUser.joinTeam(teamId);
        disableUnsafeMethods();

        try {
            Channel defaultChannel = new StandardChannel(this, "Default", defaultMeetingTime, teamId);
            register(defaultChannel);
        } catch (Exception e) {
            team.remove();
            throw e;
        }

        return team;
    }

    @Override
    public void removeTeam(Team team) throws UnauthorizedUserOperationException {
        if (!isUserTeamOwnerOf(currentUser, team))
            throw new UnauthorizedUserOperationException("Only team owners can remove a team.");

        try {
            enableUnsafeMethods();
            for (var user : users) {
                user.leaveTeam(team.getId());
            }
        } finally {
            disableUnsafeMethods();
        }

        channels.removeAll(team.getChannels());
        teams.remove(team);
    }

    @Override
    public Channel createChannel(Team sender, String name, String meetingTime) throws UnauthorizedUserOperationException {
        if (!isUserMemberOf(currentUser, sender))
            throw new UnauthorizedUserOperationException("Only team members can create channel.");

        Channel channel = new PrivateChannel(
                this,
                name,
                meetingTime,
                sender.getId(),
                new Integer[]{currentUser.getId()}
        );
        register(channel);

        return channel;
    }

    @Override
    public void removeChannel(Channel sender) throws UnauthorizedUserOperationException {
        if (!isPrivateChannel(sender))
            throw new UnauthorizedUserOperationException("Only the private channels can be removed.");

        if (!isUserParticipantOf(currentUser, (PrivateChannel) sender))
            throw new UnauthorizedUserOperationException("Only the private channel participants can remove the channel.");

        channels.remove(sender);
    }

    @Override
    public void addParticipant(Channel sender, User user) throws UnauthorizedUserOperationException {
        if (!isPrivateChannel(sender))
            throw new UnsupportedOperationException("Only private channels have participants.");

        if (!isUserParticipantOf(currentUser, (PrivateChannel) sender))
            throw new UnauthorizedUserOperationException("Only the private channel participants can add a participant.");
    }

    @Override
    public void removeParticipant(Channel sender, User user) throws UnauthorizedUserOperationException {
        if (!isPrivateChannel(sender))
            throw new UnsupportedOperationException("Only members in in private channels can be removed.");

        if (!isUserParticipantOf(currentUser, (PrivateChannel) sender))
            throw new UnauthorizedUserOperationException("Only channel participants can remove a participant.");
    }

    @Override
    public void updateMeetingDate(Channel sender, String meetingDate) throws UnauthorizedUserOperationException {
        if (isPrivateChannel(sender) && !isUserParticipantOf(currentUser, (PrivateChannel) sender))
            throw new UnauthorizedUserOperationException("Only channel participants can update meeting date.");

        if (isStandardChannel(sender) && !(isInstructor(currentUser) && isUserTeamOwnerOf(currentUser, sender.getTeam())))
            throw new UnauthorizedUserOperationException("Only instructor team owners can update meeting date.");
    }

    @Override
    public boolean addMember(Team sender, User user) throws UnauthorizedUserOperationException {
        if (!isUserMemberOf(currentUser, sender))
            throw new UnauthorizedUserOperationException("Only team members can add a member.");

        if (!isAcademician(currentUser))
            throw new UnauthorizedUserOperationException("Only academicians can add a member.");

        enableUnsafeMethods();
        boolean result = user.joinTeam(sender.getId());
        disableUnsafeMethods();

        return result;
    }


    @Override
    public boolean removeMember(Team sender, User user) throws UnauthorizedUserOperationException {
        if (!isUserMemberOf(currentUser, sender))
            throw new UnauthorizedUserOperationException("Only team members can remove a member.");

        if (!isAcademician(currentUser))
            throw new UnauthorizedUserOperationException("Only team member academicians can remove a member.");

        enableUnsafeMethods();
        boolean result = user.leaveTeam(sender.getId());
        disableUnsafeMethods();

        return result;
    }

    @Override
    public void addTeamOwner(Team sender, User user) throws UnauthorizedUserOperationException {
        if (unsafeMethodsEnabled) return;

        if (!isUserTeamOwnerOf(currentUser, sender))
            throw new UnauthorizedUserOperationException("Only team owners can add a team owner.");

        if (!isUserMemberOf(user, sender))
            throw new IllegalStateException("Only team members can be team owner.");

        if (!isTeachingAssistant(user))
            throw new IllegalArgumentException("Only teaching assistants can be added as team owner.");
    }

    @Override
    public List<Team> findTeams(Predicate<Team> predicate) {
        return teams.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Channel> findChannels(Predicate<Channel> predicate) {
        return channels.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<User> findUsers(Predicate<User> predicate) {
        return users.stream().filter(predicate).collect(Collectors.toList());
    }

    public void requestUnsafeMethodExecution() throws UnauthorizedUserOperationException {
        if (!unsafeMethodsEnabled)
            throw new UnauthorizedUserOperationException("Unsafe method execution is rejected.");
    }

    private void enableUnsafeMethods() {
        unsafeMethodsEnabled = true;
    }

    private void disableUnsafeMethods() {
        unsafeMethodsEnabled = false;
    }

    @Override
    public boolean login(String email, String password) {
        for (User user : users) {
            if (user.authorize(email, password)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    private boolean isUserTeamOwnerOf(User user, Team team) {
        return team.getTeamOwners().stream().anyMatch(u -> user.getId() == u.getId());
    }

    private boolean isUserMemberOf(User user, Team team) {
        return user.getParticipatedTeams().stream().anyMatch(t -> t.getId().equals(team.getId()));
    }

    private boolean isUserParticipantOf(User user, PrivateChannel channel) {
        return channel.getParticipants().contains(user);
    }

    private boolean isTeamIdUsed(String teamId) {
        return teams.stream().anyMatch(t -> t.getId().equals(teamId));
    }

    private boolean isTeachingAssistant(User user) {
        return user instanceof TeachingAssistant;
    }

    private boolean isAcademician(User user) {
        return user instanceof Academician;
    }

    private boolean isInstructor(User user) {
        return user instanceof Instructor;
    }

    private boolean isPrivateChannel(Channel channel) {
        return channel instanceof PrivateChannel;
    }

    private boolean isStandardChannel(Channel channel) {
        return channel instanceof StandardChannel;
    }

    private void save() throws Exception {
        dataSaver.save(this);
    }
}
