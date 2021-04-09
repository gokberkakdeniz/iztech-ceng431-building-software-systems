package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.people.IPerson;

public class AuthorizationView extends View {
    public AuthorizationView() {
        super();
    }

    @Override
    public boolean show() {
        IDataContext context = Session.getContext();
        while (true) {
            String email = keyboardReader.promptString("Please enter email");
            String password = keyboardReader.promptString("Please enter password");
            IPerson user = context.getPerson(email, password);
            if (user == null) {
                System.out.println("Wrong email or password! please try again!");
                continue;
            }
            Session.setUser(user);
            System.out.printf("Welcome %s!\n", email);
            return true;
        }
    }
}
