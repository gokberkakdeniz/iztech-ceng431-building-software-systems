package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.user.User;

import java.util.*;

public class PrivateChannel extends Channel {
    private final Set<Integer> participantIds;

    public PrivateChannel(EntityDirector director, String name, String meetingTime, String teamId, Integer[] participantIds) {
        super(director, name, meetingTime, teamId);
        this.participantIds = new HashSet<>(Arrays.asList(participantIds));
    }

    public List<Integer> getParticipantIds() {
        return new ArrayList<>(participantIds);
    }

    public boolean removeParticipant(User user) {
        participantIds.remove((Integer) user.getId());
        director.addMember(user, this);
        return true;
    }

    public boolean addParticipant(User user) {
        participantIds.add((Integer) user.getId());
        director.removeMember(user, this);
        return true;
    }
}
