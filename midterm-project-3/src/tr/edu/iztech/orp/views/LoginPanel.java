package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import tr.edu.iztech.orp.controllers.LoginController;
import tr.edu.iztech.orp.exceptions.LoginFailedException;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private final JLabel usernameLabel;
	private final JPasswordField passwordInput;
	private final JTextField usernameInput;
	private final JLabel messageLabel;
	private final LoginController userController;

	public LoginPanel(LoginController userController) {
		this.userController = userController;
		
		setLayout(null);
		setBounds(0,0, 960, 720);
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(334, 175, 77, 15);
		add(usernameLabel);
		
		usernameInput = new JTextField();
		usernameInput.setColumns(10);
		usernameInput.setBounds(439, 173, 212, 19);
		add(usernameInput);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(334, 204, 77, 15);
		add(passwordLabel);
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(439, 202, 212, 19);
		add(passwordInput);
		passwordInput.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(334, 231, 317, 25);
		loginButton.addActionListener(loginButtonListener);
		add(loginButton);
		
		messageLabel = new JLabel("");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(334, 268, 317, 15);
		add(messageLabel);
	}
	
	public void showError() {
		messageLabel.setText("The username or password is invalid.");
	}
	
	public void hideError() {
		messageLabel.setText("");
	}
	
	private ActionListener loginButtonListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	hideError();

            String username = usernameInput.getText();
            String password = String.valueOf(passwordInput.getPassword());
            
            try {
            	userController.login(username, password);
            } catch (LoginFailedException ignored) {
            	showError();
            }
        }
    };
}
