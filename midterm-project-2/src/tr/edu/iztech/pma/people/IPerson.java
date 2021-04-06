package tr.edu.iztech.pma.people;

public interface IPerson {
    String getUsername();
    boolean login(String password);
}
