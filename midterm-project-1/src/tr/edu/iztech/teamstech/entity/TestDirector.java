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

    public TestDirector(DataInitializer dataInitializer) throws Exception {
        this.teams = new LinkedList<>();
        this.users = new LinkedList<>();
        this.channels = new LinkedList<>();
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
    public boolean addTeam(User actor, Team team) {
        return false;
    }

    @Override
    public boolean removeTeam(User actor, Team team) {
        return false;
    }

    @Override
    public boolean updateTeam(User actor) {
        return false;
    }

    @Override
    public boolean findTeam(User actor, String name) {
        return false;
    }

    @Override
    public boolean addChannel(User actor, Channel channel, Team team) {
        return false;
    }

    @Override
    public boolean removeChannel(User actor, Channel team) {
        return false;
    }

    @Override
    public boolean findChannel(User actor, String name) {
        return false;
    }

    @Override
    public boolean addMember(User actor, User user, Channel channel) {
        return false;
    }

    @Override
    public boolean addMember(User actor, User user, Team channel) {
        return false;
    }

    @Override
    public boolean removeMember(User actor, User user, Channel channel) {
        return false;
    }

    @Override
    public boolean removeMember(User actor, User user, Team channel) {
        return false;
    }

    @Override
    public boolean updateMeetingDate(User actor, Channel channel) {
        return false;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }
}
