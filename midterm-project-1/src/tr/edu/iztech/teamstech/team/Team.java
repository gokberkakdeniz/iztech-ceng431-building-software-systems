package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.user.Instructor;
import tr.edu.iztech.teamstech.user.Student;
import tr.edu.iztech.teamstech.user.TeachingAssistant;
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

    public List<Channel> getChannels() {
        return director.findChannels(channel -> channel.getTeam() == this);
    }

    public List<User> getTeamOwners() {
        return new ArrayList<>(director.findUsers(u -> teamOwnerIds.contains(u.getId())));
    }

    public List<User> getMembers() {
        return director.findUsers(t->t.getParticipatedTeamIds().contains(id));
    }

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

    public TeamStatistics getStatistics() {
        List<User> members = getMembers();
        long studentCount = 0;
        long instructorCount = 0;
        long teachingAssistantCount = 0;

        for (User member: members) {
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
}
