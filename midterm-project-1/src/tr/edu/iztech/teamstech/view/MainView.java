package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.exception.UnauthorizedUserOperationException;
import tr.edu.iztech.teamstech.io.KeyboardReader;

public class MainView extends View {
    public MainView(EntityDirector director) {
        super(director);
        this.keyboardReader = new KeyboardReader();
    }

    public boolean show() throws UnauthorizedUserOperationException {
        AuthorizationView auth = new AuthorizationView(director);
        auth.bindKeyboardReader(keyboardReader);
        TeamView team = new TeamView(director);
        team.bindKeyboardReader(keyboardReader);
        boolean isLoggedIn = false;
        while (true) {
            if(!isLoggedIn) isLoggedIn = auth.show();
            if(!team.show()) return true;
        }
    }

    public void kill() {
        keyboardReader.close();
    }
}
