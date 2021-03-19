package tr.edu.iztech.teamstech.user;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.team.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class User extends Entity {
    private final int id;
    private final String username;
    private final String email;
    private final String password;
    private final List<String> teamIds;

    public User(EntityDirector director, int id, String username, String email, String password, String[] teamIds) {
        super(director);
        
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.teamIds = new ArrayList<>(Arrays.asList(teamIds));
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean authorize(String email, String password) {
        return this.password.equals(password) && this.email.equals(email);
    }

    public Team createTeam(String teamId, String name, String defaultMeetingTime) throws UnauthorizedUserOperationException {
        return director.createTeam(this, teamId, name, defaultMeetingTime);
    }

    public void joinTeam(String teamId) throws UnauthorizedUserOperationException {
        director.requestUnsafeMethodExecution();
        teamIds.add(teamId);
    }

    public void leaveTeam(String teamId) throws UnauthorizedUserOperationException {
        director.requestUnsafeMethodExecution();
        teamIds.remove(teamId);
    }

    public List<Team> getParticipatedTeams()
    {
        return director.findTeams(team -> teamIds.contains(team.getId()));
    }

    public List<String> getParticipatedTeamIds() { return teamIds; }

}
