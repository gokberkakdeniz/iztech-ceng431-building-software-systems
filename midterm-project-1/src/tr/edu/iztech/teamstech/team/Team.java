package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;

public class Team extends Entity {
    private final String id;
    private final String name;
    // TODO: add team owner attr

    public Team(EntityDirector director, String id, String name) {
        super(director);
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void remove() {
        director.removeTeam(this);
    }

    public void addMember() {
        // NOTE: uppsss katılımcıları burada mı tutsak?
    }

    public void removeMember() {
        // NOTE: uppsss katılımcıları burada mı tutsak?
    }

    public void addTeamOwner() {
        // NOTE: uppsss katılımcıları burada mı tutsak?
    }

    public void removeTeamOwner() {
        // NOTE: uppsss katılımcıları burada mı tutsak?
    }
}
