package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.io.KeyboardReader;

public class MainView extends View{
    public MainView() {
        super();
        this.keyboardReader = new KeyboardReader();
    }

    public boolean show() throws Exception {
        AuthorizationView auth = new AuthorizationView();
        auth.bindKeyboardReader(keyboardReader);
        boolean isLoggedIn = false;
        while (true) {
            if (!isLoggedIn) isLoggedIn = auth.show();
            return true;
        }
    }

    public void kill() {
        keyboardReader.close();
    }
}
