package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.EntityDirector;

public class StandardChannel extends Channel {
    public StandardChannel(EntityDirector director, String name, String meetingTime, String teamId) {
        super(director, name, meetingTime, teamId);
    }
}
