package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;

public abstract class Channel extends Entity {
    private String name;
    private String meetingTime;
    private String teamId;

    public Channel(EntityDirector director, String name, String meetingTime, String teamId) {
        super(director);

        this.name = name;
        this.meetingTime = meetingTime;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public String getMeetingTime() {
        return meetingTime;
    }
}
