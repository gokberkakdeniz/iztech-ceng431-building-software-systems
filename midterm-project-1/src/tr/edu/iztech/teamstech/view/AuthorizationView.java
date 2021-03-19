package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;

public class AuthorizationView extends View{
    public AuthorizationView(EntityDirector director) {
        super(director);
    }

    @Override
    public boolean show() {
        while (true) {
            String email = keyboardReader.promptString("Please enter email");
            String password = keyboardReader.promptString("Please enter password");
            if(!director.login(email, password)){
                System.out.println("Wrong email or password! please try again!\n");
                continue;
            }
            System.out.printf("Welcome %s!\n\n", email);
            return true;
        }
    }
}
