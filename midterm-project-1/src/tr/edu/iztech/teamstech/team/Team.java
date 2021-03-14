package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;
import tr.edu.iztech.teamstech.entity.EntityDirector;

public class Team extends Entity {
    private String id;
    private String name;

    public Team(EntityDirector director, String id, String name) {
        super(director);
        this.name = name;
        this.id = id;
    }
}
