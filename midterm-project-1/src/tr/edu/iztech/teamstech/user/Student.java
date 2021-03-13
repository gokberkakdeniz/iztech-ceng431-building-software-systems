package tr.edu.iztech.teamstech.user;

import tr.edu.iztech.teamstech.entity.EntityDirector;

public class Student extends User {
    public Student(EntityDirector director, int id, String username, String email, String password) {
        super(director, id, username, email, password);
    }
}
