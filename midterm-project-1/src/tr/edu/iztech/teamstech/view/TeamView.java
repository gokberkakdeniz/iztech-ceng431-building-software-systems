package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.io.KeyboardReader;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.List;

public class TeamView extends View {

    public TeamView(EntityDirector director) {
        super(director);
    }

    @Override
    public boolean show() throws UnauthorizedUserOperationException {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Add a team", "Remove a team", "Update a team"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 0-3", options.getPredicate());
            try {
                switch (choice) {
                    case 0:
                        return false;
                    case 1:
                        if (add())
                            return true;
                        break;
                    case 2:
                        if (remove())
                            return true;
                        break;
                    case 3:
                        if (update())
                            return true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private boolean add() throws UnauthorizedUserOperationException {
        String teamName = keyboardReader.promptString("Enter a Team Name");
        String teamId = keyboardReader.promptString("Enter a Team Id");
        String defaultMeetingDayAndTime = keyboardReader.promptString("Enter a Default Meeting Day and Time");
        User user = director.getCurrentUser();
        user.createTeam(teamId, teamName, defaultMeetingDayAndTime);
        System.out.printf("%s team is added.\n\n", teamName);
        return true;
    }

    private boolean remove() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team selectedTeam = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (selectedTeam == null) return false;

        selectedTeam.remove();
        System.out.println("Team is removed successfully.\n");
        return true;
    }

    private boolean update() throws UnauthorizedUserOperationException {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What you like to update?", new String[]{
                    "Meeting Channel", "Member",
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 1-2", options.getPredicate());
            switch (choice) {
                case 0:
                    return false;
                case 1:
                    ChannelView meeting = new ChannelView(director);
                    meeting.bindKeyboardReader(keyboardReader);
                    if (meeting.show())
                        return true;
                    break;
                case 2:
                    MemberView member = new MemberView(director);
                    member.bindKeyboardReader(keyboardReader);
                    if (member.show())
                        return true;
                    break;
            }
        }
    }
}
