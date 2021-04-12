package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.people.Admin;
import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.view.admin.AdminView;
import tr.edu.iztech.pma.view.employee.EmployeeView;
import tr.edu.iztech.pma.view.manager.ManagerView;

public class MainView extends View{
    public MainView() {
        this.keyboardReader = new KeyboardReader();
    }

    public void show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options(
                    "Available options",
                    new String[] {
                        "Login",
                        "Exit"
                    },
                    true);
            options.printOptions();
            int option = keyboardReader.promptInteger("Please select operation", options.getPredicate());
            try {
                switch (option) {
                    case 1:
                        login();
                        break;
                    case 2:
                        System.out.println("See you soon!");
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void kill() {
        keyboardReader.close();
    }

    private void login() {
        AuthorizationView auth = new AuthorizationView();
        auth.bindKeyboardReader(keyboardReader);
        auth.show();

        IPerson user = Session.getUser();

        if (user instanceof Admin) {
            AdminView view = new AdminView();
            view.bindKeyboardReader(keyboardReader);
            view.show();
        } else if (user instanceof Employee) {
            System.out.println("You are logged in as Employee!");
            EmployeeView view = new EmployeeView();
            view.bindKeyboardReader(keyboardReader);
            view.show();
        } else if (user instanceof Manager) {
            System.out.println("You are logged in as Manager!");
            ManagerView view = new ManagerView();
            view.bindKeyboardReader(keyboardReader);
            view.show();
        }

        Session.setUser(null);
    }
}
