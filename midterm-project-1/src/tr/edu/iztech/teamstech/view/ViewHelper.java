package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.io.KeyboardReader;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.List;
import java.util.function.Predicate;

public class ViewHelper {
    protected static User selectUser(Predicate<User> predicate, KeyboardReader keyboardReader, EntityDirector director) {
        List<User> users = director.findUsers(predicate);
        if (users.size() == 0) {
            System.out.println("There is no user.\n");
            return null;
        }
        System.out.println("[#] User list:");

        int i = 1;
        for (User user : users) {
            System.out.printf("[%d] %s\n", i, user.getUsername());
            i++;
        }
        int choice = keyboardReader.promptInteger("Please enter a number to select a User, enter 0 to quit",
                id -> (id >= 0 && id <= users.size()));

        if (choice == 0) return null;
        return users.get(choice - 1);
    }

    protected static Team selectTeam(KeyboardReader keyboardReader, List<Team> participatedTeams) {
        if (participatedTeams.size() == 0) {
            System.out.println("There is no team.\n");
            return null;
        }
        System.out.println("[#] Team list:");

        int i = 1;
        for (Team team : participatedTeams) {
            System.out.printf("[%d] %s (%s)\n", i, team.getName(), team.getId());
            i++;
        }
        int choice = keyboardReader.promptInteger("Please enter a number to select a team, enter 0 to quit",
                id -> (id >= 0 && id <= participatedTeams.size()));

        if (choice == 0) return null;
        return participatedTeams.get(choice - 1);
    }
}
