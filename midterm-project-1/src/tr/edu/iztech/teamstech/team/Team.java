package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Team extends Entity {
    private final String id;
    private final String name;
    private final Set<String> teamOwnerIds;

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

    public void remove() {
        director.removeTeam(this);
    }

    public List<Channel> getChannels() {
        return director.findChannels(channel -> channel.getTeamId().equals(getId()));
    }

    public List<String> getTeamOwnerIds() {
        return new ArrayList<>(teamOwnerIds);
    }

    public void addMember(User user) {
        director.addMember(user, this);
    }

    public void removeMember(User user) {
        director.removeMember(user, this);
    }

    public void addTeamOwner(String userId) {
        teamOwnerIds.add(userId);
    }

    public void removeTeamOwner(String userId) {
        teamOwnerIds.add(userId);
    }

    public void createChannel(String name, String meetingTime) {
        director.addChannel(name, meetingTime, this);
    }
}
