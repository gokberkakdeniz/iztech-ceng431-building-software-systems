package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.io.KeyboardReader;

public class MainView extends View {
    public MainView() {
        this.keyboardReader = new KeyboardReader();
    }

    public boolean show() {
        AuthorizationView auth = new AuthorizationView();
        auth.bindKeyboardReader(keyboardReader);
        TeamView team = new TeamView();
        team.bindKeyboardReader(keyboardReader);

        boolean isLoggedIn = false;
        while (true) {
            if(!isLoggedIn) isLoggedIn= auth.show();
            team.show();
        }

    }

    public void kill() {
        keyboardReader.close();
    }
}
