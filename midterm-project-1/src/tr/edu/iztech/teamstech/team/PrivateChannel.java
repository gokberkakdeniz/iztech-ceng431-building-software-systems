package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.EntityDirector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrivateChannel extends Channel {
    private List<Integer> participantIds;

    public PrivateChannel(EntityDirector director, String name, String meetingTime, String teamId, Integer[] participantIds) {
        super(director, name, meetingTime, teamId);
        this.participantIds = Arrays.asList(participantIds);
    }
}
