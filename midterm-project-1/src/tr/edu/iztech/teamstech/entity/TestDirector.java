package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.data.DataInitializer;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.PrivateChannel;
import tr.edu.iztech.teamstech.team.StandardChannel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.Academician;
import tr.edu.iztech.teamstech.user.Instructor;
import tr.edu.iztech.teamstech.user.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestDirector implements EntityDirector {
    private final List<Team> teams;
    private final List<User> users;
    private final List<Channel> channels;
    private User currentUser;
    private boolean unsafeMethodsEnabled;

    public TestDirector() {
        this.teams = new LinkedList<>();
        this.users = new LinkedList<>();
        this.channels = new LinkedList<>();
        this.unsafeMethodsEnabled = false;
    }

    public TestDirector(DataInitializer dataInitializer) throws Exception {
        this();
        dataInitializer.init(this);
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

        if (!(currentUser instanceof Instructor))
            throw new UnauthorizedUserOperationException("Only instructors can create a new team.");

        Team team = new Team(this, teamId, name);
        register(team);

        team.addTeamOwner(currentUser);

        enableUnsafeMethods();
        currentUser.joinTeam(teamId);
        disableUnsafeMethods();

        Channel defaultChannel = new StandardChannel(this, "Default", defaultMeetingTime, teamId);
        register(defaultChannel);

        return team;
    }

    @Override
    public void removeTeam(Team team) throws UnauthorizedUserOperationException {
        if (team.getTeamOwners().stream().noneMatch(u->currentUser.getId() == u.getId()))
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
        if (!currentUser.getParticipatedTeams().contains(sender))
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
        if (!(sender instanceof PrivateChannel))
            throw new UnauthorizedUserOperationException("Only private channels can be removed.");

        if (!((PrivateChannel) sender).getParticipants().contains(currentUser))
            throw new UnauthorizedUserOperationException("Only private channel participants can remove the channel.");

        channels.remove(sender);
    }

    @Override
    public void addParticipant(Channel sender, User user) throws UnauthorizedUserOperationException {
        if (!(sender instanceof PrivateChannel))
            throw new UnsupportedOperationException("Only private channels have participants.");

        if (((PrivateChannel) sender).getParticipants().contains(currentUser))
            throw new UnauthorizedUserOperationException("Only channel participants can add a participant.");
    }

    @Override
    public void removeParticipant(Channel sender, User user) throws UnauthorizedUserOperationException {
        if (!(sender instanceof PrivateChannel))
            throw new UnsupportedOperationException("Only members in in private channels can be removed.");

        if (((PrivateChannel) sender).getParticipants().contains(currentUser))
            throw new UnauthorizedUserOperationException("Only channel participants can remove a participant.");
    }

    @Override
    public void updateMeetingDate(Channel sender, String meetingDate) throws UnauthorizedUserOperationException {
        if (sender instanceof PrivateChannel
                && ((PrivateChannel) sender).getParticipants().contains(currentUser))
            throw new UnauthorizedUserOperationException("Only channel participants can update meeting date.");

        if (sender instanceof StandardChannel
                && currentUser instanceof Instructor
                && teams.stream().anyMatch(t -> t.getId().equals(sender.getTeamId())
                                                && t.getTeamOwners().stream().anyMatch(u -> currentUser.getId() == u.getId())))
            throw new UnauthorizedUserOperationException("Only instructor team owners can update meeting date.");
    }

    @Override
    public void addMember(Team sender, User user) throws UnauthorizedUserOperationException {
        if (currentUser.getParticipatedTeams().stream().noneMatch(t->t.getId().equals(sender.getId())))
            throw new UnauthorizedUserOperationException("Only team members can add a member.");

        if (!(currentUser instanceof Academician))
            throw new UnauthorizedUserOperationException("Only academicians can add a member.");

        enableUnsafeMethods();
        user.joinTeam(sender.getId());
        disableUnsafeMethods();
    }


    @Override
    public void removeMember(Team sender, User user) throws UnauthorizedUserOperationException {
        if (currentUser.getParticipatedTeams().stream().noneMatch(t->t.getId().equals(sender.getId())))
            throw new UnauthorizedUserOperationException("Only team members can remove a member.");

        if (!(currentUser instanceof Academician))
            throw new UnauthorizedUserOperationException("Only team member academicians can remove a member.");

        enableUnsafeMethods();
        user.leaveTeam(sender.getId());
        disableUnsafeMethods();
    }

    @Override
    public void addTeamOwner(Team sender, User user) throws UnauthorizedUserOperationException {
        if (sender.getTeamOwners().stream().noneMatch(u -> currentUser.getId() == u.getId()))
            throw new UnauthorizedUserOperationException("Only team owners can add a team owner.");

        if (!user.getParticipatedTeams().contains(sender))
            throw new IllegalStateException("Only team members can be team owner.");

        if (!(user instanceof Instructor))
            throw new IllegalArgumentException("Only teaching assistants can be added as team owner.");
    }

    @Override
    public List<Team> findTeams(Predicate<Team> predicate) {
        return teams.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Team> findTeams() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<Channel> findChannels(Predicate<Channel> predicate) {
        return channels.stream().filter(predicate).collect(Collectors.toList());
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
    public List<Channel> findChannels() {
        return new ArrayList<>(channels);
    }

    @Override
    public List<User> findUsers(Predicate<User> predicate) {
        return users.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<User> findUsers() {
        return new ArrayList<>(users);
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
}
