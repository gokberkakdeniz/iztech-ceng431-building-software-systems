package tr.edu.iztech.teamstech.entity;

public abstract class Entity {
    protected final EntityDirector director;

    public Entity(EntityDirector director) {
        this.director = director;
    }
}
