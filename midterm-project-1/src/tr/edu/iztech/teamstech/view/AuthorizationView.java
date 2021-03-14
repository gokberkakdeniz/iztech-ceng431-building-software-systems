package tr.edu.iztech.teamstech.view;

public class AuthorizationView extends View{

    @Override
    public boolean show() {

        while (true) {
            String email = keyboardReader.promptString("Please enter email");
            String password = keyboardReader.promptString("Please enter password");
            System.out.printf("Welcome %s!\n", email);
//            Do authentication check
            return true;
        }
    }
}
