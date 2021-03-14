package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.io.KeyboardReader;

public class MeetingView extends View{
    @Override
    public boolean show() {
        while(true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Add a meeting channel", "Remove a meeting channel", "Add a participant", "Remove a participant", "Update Meeting Day and Time"
            }, true);
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 1-5", options.getPredicate());
            switch (choice) {
                case 1:
                    if(addChannel())
                        return true;
                    break;
                case 2:
                    if(removeChannel())
                        return true;
                    break;
                case 3:
                    if(addParticipant())
                        return true;
                    break;
                case 4:
                    if(removeParticipant())
                        return true;
                    break;
                case 5:
                    if(updateMeetingDate())
                        return true;
                    break;
            }
        }
    }

    private boolean addChannel() {
        String channelName = keyboardReader.promptString("Enter a channel name");
        String meetingDayAndTime = keyboardReader.promptString("Enter meeting day and time");
        return true;
    }

    private boolean removeChannel() {
        System.out.println("List of channels:\n");
        int choice = keyboardReader.promptInteger("Enter a number to delete channel");
        return true;
    }

    private boolean addParticipant() {
        System.out.println("List of channels:\n");
        int channelId = keyboardReader.promptInteger("Enter a number to choose channel");
        System.out.println("List of available participants:\n");
        int participantId = keyboardReader.promptInteger("Enter a number to choose participant");
        return true;
    }

    private boolean removeParticipant() {
        System.out.println("List of channels:\n");
        int channelId = keyboardReader.promptInteger("Enter a number to choose channel");
        System.out.println("List of available participants:\n");
        int participantId = keyboardReader.promptInteger("Enter a number to choose participant");
        return true;
    }

    private boolean updateMeetingDate() {
        System.out.println("List of channels:\n");
        int channelId = keyboardReader.promptInteger("Enter a number to choose channel");
        String newDayAndTime = keyboardReader.promptString("Enter new Day and Time");
        return true;
    }
}
