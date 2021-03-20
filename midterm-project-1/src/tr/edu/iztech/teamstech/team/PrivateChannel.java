package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.user.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrivateChannel extends Channel {
    private final Set<Integer> participantIds;

    public PrivateChannel(EntityDirector director, String name, String meetingTime, String teamId, Integer[] participantIds) {
        super(director, name, meetingTime, teamId);
        this.participantIds = new HashSet<>(Arrays.asList(participantIds));
    }

    public List<User> getParticipants() {
        return director.findUsers(u -> participantIds.contains(u.getId()));
    }

    public boolean removeParticipant(User user) throws UnauthorizedUserOperationException {
        director.removeParticipant(this, user);

        return participantIds.remove((Integer) user.getId());
    }

    public boolean addParticipant(User user) throws UnauthorizedUserOperationException {
        director.addParticipant(this, user);

        return participantIds.add((Integer) user.getId());
    }
}
