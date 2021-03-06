package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.user.Instructor;
import tr.edu.iztech.teamstech.user.Student;
import tr.edu.iztech.teamstech.user.TeachingAssistant;
import tr.edu.iztech.teamstech.user.User;

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

    public List<Channel> getChannels() {
        return director.findChannels(channel -> channel.getTeam() == this);
    }

    public List<User> getTeamOwners() {
        return director.findUsers(u -> teamOwnerIds.contains(u.getId()));
    }

    public List<User> getMembers() {
        return director.findUsers(u -> u.getParticipatedTeams().contains(this));
    }

    public boolean addMember(User user) throws UnauthorizedUserOperationException {
        return director.addMember(this, user);
    }

    public boolean removeMember(User user) throws UnauthorizedUserOperationException {
        return director.removeMember(this, user);
    }

    public boolean addTeamOwner(User user) throws UnauthorizedUserOperationException {
        director.addTeamOwner(this, user);
        return teamOwnerIds.add(user.getId());
    }

    public boolean removeTeamOwner(User user) throws UnauthorizedUserOperationException {
        director.removeTeamOwner(this, user);
        return teamOwnerIds.remove(user.getId());
    }

    public Channel createChannel(String name, String meetingTime) throws UnauthorizedUserOperationException {
        return director.createChannel(this, name, meetingTime);
    }

    public TeamStatistics getStatistics() {
        List<User> members = getMembers();
        long studentCount = 0;
        long instructorCount = 0;
        long teachingAssistantCount = 0;

        for (User member : members) {
            if (member instanceof Student)
                studentCount++;
            else if (member instanceof Instructor)
                instructorCount++;
            else if (member instanceof TeachingAssistant)
                teachingAssistantCount++;
        }

        return new TeamStatistics(studentCount, instructorCount, teachingAssistantCount);
    }

    public static class TeamStatistics {
        public final long studentCount;
        public final long instructorCount;
        public final long teachingAssistantCount;

        public TeamStatistics(long studentCount, long instructorCount, long teachingAssistantCount) {
            this.studentCount = studentCount;
            this.instructorCount = instructorCount;
            this.teachingAssistantCount = teachingAssistantCount;
        }
    }

    public String toString() {
        List<Channel> channels = getChannels();
        Channel defaultChannel = channels.get(0);
        String privateChannelsColumns = String.join(
                ",",
                channels.stream().
                        skip(1)
                        .map(c -> String.format(
                                "%s,%s,\"%s\"",
                                c.getName(),
                                c.getMeetingTime(),
                                String.join(",", ((PrivateChannel) c).getParticipants().stream().map(User::getId).map(String::valueOf).toArray(String[]::new))
                        )).toArray(String[]::new));
        String teamOwnerColumn = String.join(",", teamOwnerIds.stream().map(String::valueOf).toArray(String[]::new));
        if (channels.size() == 1) privateChannelsColumns += ",,";

        return String.format(
                "%s,%s,%s,%s,%s,\"%s\"",
                name,
                id,
                defaultChannel.getName(),
                defaultChannel.getMeetingTime(),
                privateChannelsColumns,
                teamOwnerColumn
        );
    }
}
