package tr.edu.iztech.teamstech.user;

import tr.edu.iztech.teamstech.entity.Entity;

public abstract class User extends Entity {
    private final int id;
    private final String username;
    private final String email;
    private final String password;

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
