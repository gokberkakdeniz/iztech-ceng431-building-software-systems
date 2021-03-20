package tr.edu.iztech.teamstech.data;

import tr.edu.iztech.teamstech.entity.EntityDirector;

public abstract class DataSaver {
    public abstract void save(EntityDirector director) throws Exception;
}
