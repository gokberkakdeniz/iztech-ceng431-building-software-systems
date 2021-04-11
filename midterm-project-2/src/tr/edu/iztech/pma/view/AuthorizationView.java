package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.people.IPerson;

public class AuthorizationView extends View {

    @Override
    public void show() {
        IDataContext context = Session.getContext();
        String email = keyboardReader.promptString("Please enter email");
        String password = keyboardReader.promptString("Please enter password");
        IPerson user = context.getPerson(email, password);
        if (user == null) {
            System.out.println("Wrong email or password! please try again!");
            return;
        }
        Session.setUser(user);
        System.out.printf("Welcome %s!\n", email);
    }
}
