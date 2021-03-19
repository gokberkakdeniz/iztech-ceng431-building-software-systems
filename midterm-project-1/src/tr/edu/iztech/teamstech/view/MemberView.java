package tr.edu.iztech.teamstech.view;

import com.sun.jdi.event.VMDisconnectEvent;
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
                    "Add a member", "Remove a member", "Update a member", "Find a member"
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
                case 4:
                    if (findMember())
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

        User selectedUser = ViewHelper.selectUser(t->true, keyboardReader, director);
        if (selectedUser == null) return false;

        team.addMember(selectedUser);

        System.out.println("User is added to the Team successfully.\n");
        return true;
    }

    private boolean removeMember() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team team = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (team == null) return false;

        User selectedUser = ViewHelper.selectUser(t->team.getMembers().contains(t), keyboardReader, director);
        if (selectedUser == null) return false;

        team.removeMember(selectedUser);

        System.out.println("User is removed from the Team successfully.\n");
        return true;
    }

    private boolean updateMember() {
        System.out.println("List of members:\n");
        int choice = keyboardReader.promptInteger("Enter a number to delete member");
        String userName = keyboardReader.promptString("Enter new username");
        return true;
    }

    private boolean findMember() {
        int choice = keyboardReader.promptInteger("Enter a number to find member");
        return true;
    }
}