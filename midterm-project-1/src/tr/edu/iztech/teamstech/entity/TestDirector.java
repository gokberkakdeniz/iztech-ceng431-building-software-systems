package tr.edu.iztech.teamstech.entity;

import tr.edu.iztech.teamstech.data.DataInitializer;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.LinkedList;
import java.util.List;

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
    public boolean addTeam(Team team) {
        return false;
    }

    @Override
    public void removeTeam(Team team) {

    }

    @Override
    public boolean updateTeam(User actor) {
        return false;
    }

    @Override
    public boolean findTeam(String name) {
        return false;
    }

    @Override
    public boolean addChannel(Channel channel, Team team) {
        return false;
    }

    @Override
    public boolean removeChannel(Channel team) {
        return false;
    }

    @Override
    public boolean findChannel(String name) {
        return false;
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
