package tr.edu.iztech.teamstech.team;

import tr.edu.iztech.teamstech.entity.Entity;

public abstract class Channel extends Entity {
    private final int id;
    private final String name;

    public Channel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
