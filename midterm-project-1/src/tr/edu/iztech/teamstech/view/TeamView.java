package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.io.KeyboardReader;

public class TeamView extends View{

    public TeamView(EntityDirector director) {
        super(director);
    }

    @Override
    public boolean show() {
        while(true) {
        KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[] {
            "Add a team", "Remove a team", "Update a team"
        });
        options.printOptions();
        int choice = keyboardReader.promptInteger("Please enter a number between 0-3", options.getPredicate());
        switch (choice) {
            case 0:
                return false;
            case 1:
                if(add())
                    return true;
                break;
            case 2:
                if(remove())
                    return true;
                break;
            case 3:
                if(update())
                    return true;
                break;
        }
        }
    }

    private boolean add() {
        String teamName = keyboardReader.promptString("Enter a Team Name");
        String teamId = keyboardReader.promptString("Enter a Team Id");
        String defaultMeetingDayAndTime = keyboardReader.promptString("Enter a Default Meeting Day and Time");
        System.out.printf("%s team is added.\n", teamName);
        return true;
    }

    private boolean remove() {
        System.out.println("List of your teams:\n");
        int choice = keyboardReader.promptInteger("Please enter a number to delete team");
        return true;
    }

    private boolean update() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("CCCWhat you like to do?", new String[] {
                    "Meeting Channel", "Member",
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 1-2", options.getPredicate());
            switch (choice) {
                case 0:
                    return false;
                case 1:
                    MeetingView meeting = new MeetingView(director);
                    meeting.bindKeyboardReader(keyboardReader);
                    if(meeting.show())
                        return true;
                    break;
                case 2:
                    MemberView member = new MemberView(director);
                    member.bindKeyboardReader(keyboardReader);
                    if(member.show())
                        return true;
                    break;
            }
        }
    }
}
