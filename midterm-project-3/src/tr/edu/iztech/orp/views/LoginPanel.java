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
	private JLabel usernameLabel;
	private JPasswordField passwordInput;
	private JTextField usernameInput;
	private JLabel messageLabel;

	public LoginPanel(ActionListener loginButtonListener) {
		setLayout(null);
		setBounds(0,0, 960, 720);
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(266, 129, 77, 15);
		add(usernameLabel);
		
		usernameInput = new JTextField();
		usernameInput.setColumns(10);
		usernameInput.setBounds(371, 127, 212, 19);
		add(usernameInput);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(266, 158, 77, 15);
		add(passwordLabel);
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(372, 156, 208, 19);
		add(passwordInput);
		passwordInput.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(266, 208, 314, 25);
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
		
		messageLabel = new JLabel("New label");
		messageLabel.setBounds(266, 181, 341, 15);
		add(messageLabel);
		
	}
	
	public void showError() {
		messageLabel.setText("The username or password is invalid.");
	}
	
	public void hideError() {
		messageLabel.setText("");
	}
}
