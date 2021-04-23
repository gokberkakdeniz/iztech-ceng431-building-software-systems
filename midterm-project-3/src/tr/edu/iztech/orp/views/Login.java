package tr.edu.iztech.orp.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel loginPanel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JLabel applicationNameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel errorMessage;

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                errorMessage.setVisible(!errorMessage.isVisible());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Screen");
        frame.setContentPane(new Login().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
