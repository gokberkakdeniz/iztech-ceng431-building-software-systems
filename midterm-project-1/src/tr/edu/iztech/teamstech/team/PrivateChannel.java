package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
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

    public List<User> getParticipants() {
        return director.findUsers(t->participantIds.contains(t.getId()));
    }

    public void removeParticipant(User user) throws UnauthorizedUserOperationException {
        director.removeParticipant(this, user);

        participantIds.remove((Integer) user.getId());
    }

    public void addParticipant(User user) throws UnauthorizedUserOperationException {
        director.addParticipant(this, user);

        participantIds.add((Integer) user.getId());
    }
}
