package tr.edu.iztech.teamstech;

public class User {
    String userType;
    String userName;
    int userId;
    String email;
    String password;
    String teamId;

    public User(String userType, String userName, Integer userId, String email, String password, String teamId) {
        this.userType = userType;
        this.userName = userName;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.teamId = teamId;
    }
}