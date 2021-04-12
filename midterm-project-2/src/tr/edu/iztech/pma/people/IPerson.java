package tr.edu.iztech.pma.people;

public interface IPerson {
    /**
     * Gets username of person
     *
     * @return username
     */
    String getUsername();

    /**
     * Checks if authorized
     * @param password password to be compared
     *
     * @return if passwords are equal returns true, otherwise false
     */
    boolean login(String password);
}
