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
    public boolean show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Add a team", "Remove a team", "Update a team", "Print Statistics for team"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 0-4", options.getPredicate());
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
                    case 4:
                        if (printStatistics())
                            return true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
            int choice = keyboardReader.promptInteger("Please enter a number between 0-2", options.getPredicate());
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

    private boolean printStatistics() {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team selectedTeam = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (selectedTeam == null) return false;

        var stat = selectedTeam.getStatistics();

        System.out.printf("Student Count: %d\n", stat.studentCount);
        System.out.printf("Instructor Count: %d\n", stat.instructorCount);
        System.out.printf("Teaching Assistant Count: %d\n\n", stat.teachingAssistantCount);
        return true;
    }
}
