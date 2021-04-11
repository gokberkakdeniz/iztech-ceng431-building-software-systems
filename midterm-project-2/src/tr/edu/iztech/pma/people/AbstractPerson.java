package tr.edu.iztech.pma.people;

import com.google.gson.annotations.Expose;

public abstract class AbstractPerson implements IPerson {
    @Expose
    private final String username;
    @Expose
    private final String password;
    @Expose
    private final String type;

    public AbstractPerson(String username, String password) {
        this.username = username;
        this.password = password;
        this.type = this.getClass().getSimpleName();
    }

    public String getUsername() {
        return username;
    }

    public boolean login(String password) {
        return this.password.equals(password);
    }
}
