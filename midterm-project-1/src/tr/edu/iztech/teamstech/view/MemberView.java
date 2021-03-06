package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.io.KeyboardReader;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.List;

public class MemberView extends View {
    public MemberView(EntityDirector director) {
        super(director);
    }

    @Override
    public boolean show() throws UnauthorizedUserOperationException {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Add a member", "Remove a member", "Update a member as a Team Owner"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 1-3", options.getPredicate());
            switch (choice) {
                case 0:
                    return false;
                case 1:
                    if (addMember())
                        return true;
                    break;
                case 2:
                    if (removeMember())
                        return true;
                    break;
                case 3:
                    if (updateMember())
                        return true;
                    break;
            }
        }
    }

    private boolean addMember() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team team = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (team == null) return false;

        User selectedUser = ViewHelper.selectUser(u -> true, keyboardReader, director);
        if (selectedUser == null) return false;

        boolean result = team.addMember(selectedUser);
        if (result) {
            System.out.println("User is added to the Team successfully.\n");
            return true;
        } else {
            System.out.println("User could not added to the Team.\n");
            return false;
        }
    }

    private boolean removeMember() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team team = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (team == null) return false;

        User selectedUser = ViewHelper.selectUser(u -> team.getMembers().contains(u), keyboardReader, director);
        if (selectedUser == null) return false;

        boolean result = team.removeMember(selectedUser);
        if (result) {
            System.out.println("User is removed from the Team successfully.\n");
            return true;
        } else {
            System.out.println("User is could not removed from the Team.\n");
            return false;
        }
    }

    private boolean updateMember() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team team = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (team == null) return false;

        List<User> teamMembers = team.getMembers();
        System.out.println("[#] List of members:");
        int i = 1;
        for (User member : teamMembers) {
            System.out.printf("[%d] %s, %s\n", i, member.getUsername(), member.getClass().getSimpleName());
            i++;
        }

        int choice = keyboardReader.promptInteger("Enter a number to promote member as a Team Owner, 0 to quit");
        if (choice == 0) return false;

        User selectedUser = teamMembers.get(choice - 1);
        boolean result = team.addTeamOwner(selectedUser);
        if (result) {
            System.out.printf("%s is now a Team Owner of %s.\n", selectedUser.getUsername(), team.getName());
            return true;
        } else {
            System.out.println("Team Owner could not added.\n");
            return false;
        }
    }

}