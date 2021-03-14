package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.io.KeyboardReader;

public class MemberView extends View {
    @Override
    public boolean show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Add a member", "Remove a member", "Update a member", "Find a member"
            }, true);
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 1-3", options.getPredicate());
            switch (choice) {
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

    private boolean addMember() {
        KeyboardReader.Options options = new KeyboardReader.Options("Choose member type.", new String[]{
                "Instructor", "Teaching Assistant", "Student"
        }, true);
        options.printOptions();
        int choice = keyboardReader.promptInteger("Please enter a number between 1-3", options.getPredicate());
        String userName = keyboardReader.promptString("Enter username");
        return true;
    }

    private boolean removeMember() {
        System.out.println("List of members:\n");
        int choice = keyboardReader.promptInteger("Enter a number to delete member");
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