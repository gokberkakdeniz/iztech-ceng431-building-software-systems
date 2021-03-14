package tr.edu.iztech.teamstech.user;

import tr.edu.iztech.teamstech.entity.EntityDirector;

public abstract class Academician extends User {
    public Academician(EntityDirector director, int id, String username, String email, String password, String[] teamIds) {
        super(director, id, username, email, password, teamIds);
    }
}
