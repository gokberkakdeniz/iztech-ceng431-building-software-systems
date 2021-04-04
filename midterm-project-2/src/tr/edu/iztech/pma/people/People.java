package tr.edu.iztech.pma.people;

public abstract class People {
    private final String username;
    private final String password;
    private final String type;

    public People(String username, String password) {
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
