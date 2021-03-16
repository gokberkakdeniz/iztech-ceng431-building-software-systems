package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.data.DataInitializer;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.PrivateChannel;
import tr.edu.iztech.teamstech.team.StandardChannel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.Instructor;
import tr.edu.iztech.teamstech.user.User;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestDirector implements EntityDirector {
    private final List<Team> teams;
    private final List<User> users;
    private final List<Channel> channels;
    private User currentUser;

    public TestDirector() {
        this.teams = new LinkedList<>();
        this.users = new LinkedList<>();
        this.channels = new LinkedList<>();
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

        team.addTeamOwner(currentUser.getId());
        currentUser.addToTeam(teamId);

        Channel defaultChannel = new StandardChannel(this, "Default", defaultMeetingTime, teamId);
        register(defaultChannel);

        return team;
    }

    @Override
    public void removeTeam(Team team) throws UnauthorizedUserOperationException {
        if (!team.getTeamOwnerIds().contains(currentUser.getId()))
            throw new UnauthorizedUserOperationException("Only team owners can remove a team.");

        users.forEach(u -> u.leaveTeam(team.getId()));
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

        if (!((PrivateChannel) sender).getParticipantIds().contains(currentUser.getId()))
            throw new UnauthorizedUserOperationException("Only private channel participants can remove the channel.");

        channels.remove(sender);
    }

    @Override
    public void addParticipant(Channel sender, User user) {

    }

    @Override
    public void addMember(Team sender, User user) {

    }

    @Override
    public void removeParticipant(Channel sender, User user) {

    }

    @Override
    public void removeMember(Team sender, User user) {

    }

    @Override
    public boolean updateMeetingDate(Channel channel) {
        return false;
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
