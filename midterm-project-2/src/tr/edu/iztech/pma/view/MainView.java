package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.view.admin.AdminView;

public class MainView extends View{
    public MainView() {
        this.keyboardReader = new KeyboardReader();
    }

    public boolean show() {
        AuthorizationView auth = new AuthorizationView();
        auth.bindKeyboardReader(keyboardReader);
        auth.show();
        String userType = Session.getUser().getClass().getSimpleName();
        switch (userType) {
            case "Admin":
                AdminView view = new AdminView();
                view.bindKeyboardReader(keyboardReader);
                view.show();
                break;
            case "Employee":
                System.out.println("You are logged in as Employee!");
                break;
            case "Manager":
                System.out.println("You are logged in as Manager!");
                break;
        }
        return true;
    }

    public void kill() {
        keyboardReader.close();
    }
}
