package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.io.KeyboardReader;
import tr.edu.iztech.teamstech.team.Channel;
import tr.edu.iztech.teamstech.team.PrivateChannel;
import tr.edu.iztech.teamstech.team.Team;
import tr.edu.iztech.teamstech.user.User;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChannelView extends View {

    public ChannelView(EntityDirector director) {
        super(director);
    }

    @Override
    public boolean show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Add a meeting channel", "Remove a meeting channel", "Monitor a meeting channel", "Add a participant", "Remove a participant", "Update Meeting Day and Time"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 1-5", options.getPredicate());
            try {
                switch (choice) {
                    case 0:
                        return false;
                    case 1:
                        if (addChannel())
                            return true;
                        break;
                    case 2:
                        if (removeChannel())
                            return true;
                        break;
                    case 3:
                        if (monitorChannel())
                            return true;
                        break;
                    case 4:
                        if (addParticipant())
                            return true;
                        break;
                    case 5:
                        if (removeParticipant())
                            return true;
                        break;
                    case 6:
                        if (updateMeetingDate())
                            return true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected Channel selectChannel(Predicate<Channel> predicate) {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team selectedTeam = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (selectedTeam == null) return null;

        List<Channel> channels = selectedTeam.getChannels().stream().filter(predicate).collect(Collectors.toList());

        if (channels.size() == 0) {
            System.out.println("There is no channel.\n");
            return null;
        }
        System.out.println("[#] Channel list:");

        int i = 1;
        for (Channel channel : channels) {
            System.out.printf("[%d] %s\n", i, channel.getName());
            i++;
        }
        int choice = keyboardReader.promptInteger("Please enter a number to select a channel, enter 0 to quit",
                id -> (id >= 0 && id <= channels.size()));

        if (choice == 0) return null;
        return channels.get(choice - 1);
    }

    private boolean addChannel() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Team selectedTeam = ViewHelper.selectTeam(keyboardReader, participatedTeams);
        if (selectedTeam == null) return false;

        String channelName = keyboardReader.promptString("Enter a channel name");
        String dayAndTime = keyboardReader.promptString("Enter meeting day and time");

        selectedTeam.createChannel(channelName, dayAndTime);
        System.out.println("Channel is added successfully.\n");
        return true;
    }

    private boolean removeChannel() throws UnauthorizedUserOperationException {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        Channel channel = selectChannel(t -> true);
        if (channel == null) return false;

        channel.remove();
        System.out.println("Channel is removed successfully.\n");
        return true;
    }

    private boolean monitorChannel() {
        User user = director.getCurrentUser();
        List<Team> participatedTeams = user.getParticipatedTeams();

        PrivateChannel channel = (PrivateChannel) selectChannel(t -> t instanceof PrivateChannel);
        if (channel == null) return false;

        System.out.printf("Name: %s\nMeeting Time: %s\n", channel.getName(), channel.getMeetingTime());
        List<User> participants = channel.getParticipants();

        System.out.println("Participants:");
        int i = 0;
        for (User member : participants) {
            System.out.printf("%d: %s, %s\n", i, member.getUsername(), member.getClass().getSimpleName());
            i++;
        }
        return true;
    }

    private boolean addParticipant() throws UnauthorizedUserOperationException {
        PrivateChannel channel = (PrivateChannel) selectChannel(t -> t instanceof PrivateChannel);
        if (channel == null) return false;

        User user = ViewHelper.selectUser(t -> true, keyboardReader, director);
        if (user == null) return false;

        channel.addParticipant(user);
        System.out.println("Participant added successfully.\n");
        return true;
    }

    private boolean removeParticipant() throws UnauthorizedUserOperationException {
        PrivateChannel channel = (PrivateChannel) selectChannel(t -> t instanceof PrivateChannel);
        if (channel == null) return false;

        User user = ViewHelper.selectUser(t -> channel.getParticipants().contains(t), keyboardReader, director);
        if (user == null) return false;

        channel.removeParticipant(user);
        System.out.println("Participant removed successfully.\n");
        return true;
    }

    private boolean updateMeetingDate() throws UnauthorizedUserOperationException {
        Channel channel = selectChannel(t -> true);
        if (channel == null) return false;

        String newDayAndTime = keyboardReader.promptString("Enter new Day and Time");
        channel.setMeetingTime(newDayAndTime);

        System.out.println("Channel Updated successfully.\n");
        return true;
    }
}
