package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JLabel messageLabel;
	private Component verticalStrut;

	public LoginPanel(ActionListener loginButtonListener) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel usernameLabel = new JLabel("Username:");
		add(usernameLabel);
		
		usernameInput = new JTextField();
		add(usernameInput);
		usernameInput.setColumns(30);
		
		JLabel passwordLabel = new JLabel("Password:");
		add(passwordLabel);
		
		passwordInput = new JPasswordField();
		add(passwordInput);
		passwordInput.setColumns(30);
		
		messageLabel = new JLabel("");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setForeground(Color.RED);
		add(messageLabel);
		
		JButton loginButton = new JButton("Login");

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameInput.getText();
				String password = String.valueOf(passwordInput.getPassword());
				
				if (username.equals("") && password.equals("")) {
					loginButtonListener.actionPerformed(e);
				} else {
					showError();
				}
				

			}
		});
		add(loginButton);
		
		verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);
	}
	
	public void showError() {
		messageLabel.setText("The username or password is invalid.");
	}
	
	public void hideError() {
		messageLabel.setText("");
	}
}
