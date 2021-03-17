package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Channel extends Entity {
    private final String name;
    private String meetingTime;
    private final String teamId;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE hh:mm a");

    public Channel(EntityDirector director, String name, String meetingTime, String teamId) {
        super(director);

        this.name = name;
        this.meetingTime = meetingTime;
        this.teamId = teamId;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) throws UnauthorizedUserOperationException {
        director.updateMeetingDate(this, meetingTime);

        try {
            dateFormat.parse(meetingTime);
            this.meetingTime = meetingTime;
        } catch (ParseException e) {
            throw new IllegalArgumentException("The argument 'meetingTime' must be like 'Monday 09:45 AM'.");
        }
    }

    public void remove() throws UnauthorizedUserOperationException {
        director.removeChannel(this);
    }
}
