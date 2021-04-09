package tr.edu.iztech.pma.view;

public class AuthorizationView extends View{
    public AuthorizationView() {
        super();
    }

    @Override
    public boolean show() {
        while (true) {
            String email = keyboardReader.promptString("Please enter email");
            String password = keyboardReader.promptString("Please enter password");
            if (true) { // login
                System.out.println("Wrong email or password! please try again!\n");
                continue;
            }
            System.out.printf("Welcome %s!\n\n", email);
            return true;
        }
    }
}
