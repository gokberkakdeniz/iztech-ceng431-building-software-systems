package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Team extends Entity {
    private final String id;
    private final String name;
    private final Set<Integer> teamOwnerIds;

    public Team(EntityDirector director, String id, String name) {
        super(director);
        this.name = name;
        this.id = id;
        this.teamOwnerIds = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void remove() throws UnauthorizedUserOperationException {
        director.removeTeam(this);
    }

    public List<Channel> getChannels() { return director.findChannels(channel -> channel.getTeamId().equals(getId()));}

    public List<Integer> getTeamOwnerIds() {
        return new ArrayList<>(teamOwnerIds);
    }

    public List<User> getMembers() { return director.findUsers(t->t.getParticipatedTeamIds().contains(id)); }

    public void addMember(User user) throws UnauthorizedUserOperationException {
        director.addMember(this, user);
    }

    public void removeMember(User user) throws UnauthorizedUserOperationException {
        director.removeMember(this, user);
    }

    public void addTeamOwner(User user) throws UnauthorizedUserOperationException {
        director.addTeamOwner(this, user);
        teamOwnerIds.add(user.getId());
    }

    public Channel createChannel(String name, String meetingTime) throws UnauthorizedUserOperationException {
        return director.createChannel(this, name, meetingTime);
    }
}
