package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.data.DataInitializer;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.StandardChannel;
import tr.edu.iztech.teamstech.team.Team;
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
    public boolean addTeam(String teamId, String name, String defaultMeetingTime) {
        Team team = new Team(this, teamId, name);
        register(team);

        Channel defaultChannel = new StandardChannel(this, "Default", defaultMeetingTime, teamId);
        register(defaultChannel);

        currentUser.addToTeam(teamId);

        return false;
    }

    @Override
    public void removeTeam(Team team) {
        users.forEach(user -> user.leaveTeam(team.getId()));
        channels.removeAll(team.getChannels());
        teams.remove(team);
    }

    @Override
    public List<Team> findTeams(Predicate<Team> predicate) {
        return teams.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean addChannel(String name, String meetingTime, Team team) {
        return false;
    }

    @Override
    public boolean removeChannel(Channel team) {
        return channels.remove(team);
    }

    @Override
    public List<Channel> findChannels(Predicate<Channel> predicate) {
        return channels.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean addMember(User user, Channel channel) {
        return false;
    }

    @Override
    public boolean addMember(User user, Team channel) {
        return false;
    }

    @Override
    public boolean removeMember(User user, Channel channel) {
        return false;
    }

    @Override
    public boolean removeMember(User user, Team channel) {
        return false;
    }

    @Override
    public boolean updateMeetingDate(Channel channel) {
        return false;
    }

    @Override
    public boolean login(String email, String password) {
        for (User user: users) {
            if(user.authorize(email, password)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }
}
