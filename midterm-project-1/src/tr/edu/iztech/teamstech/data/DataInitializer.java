package tr.edu.iztech.teamstech.data;

import tr.edu.iztech.teamstech.entity.EntityDirector;

public abstract class DataInitializer {
    public DataInitializer() {}

    public abstract void init(EntityDirector director) throws Exception;
}
