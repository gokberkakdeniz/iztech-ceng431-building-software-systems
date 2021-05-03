package tr.edu.iztech.orp.views.screens;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Description:
 * 	This view shows user name and password inputs, a error label, and a button.
 * 
 * Behavior:
 * - When user fills user name and password fields correctly, home page shows up.
 * - When user fills user name and password fields incorrectly or keep them empty, the error message shows up.
 */
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
		
		passwordInput = new JPasswordField("123456");
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
		
		ezUsernames1 = new JTextField();
		ezUsernames1.setToolTipText("Click for set username input");
		ezUsernames1.setText("alp");
		ezUsernames1.setEditable(false);
		ezUsernames1.setBounds(158, 348, 114, 19);
		add(ezUsernames1);
		ezUsernames1.setColumns(10);
		
		ezUsernames2 = new JTextField();
		ezUsernames2.setToolTipText("Click for set username input");
		ezUsernames2.setText("akdeniz");
		ezUsernames2.setEditable(false);
		ezUsernames2.setColumns(10);
		ezUsernames2.setBounds(284, 348, 114, 19);
		add(ezUsernames2);
		
		ezUsernames3 = new JTextField();
		ezUsernames3.setToolTipText("Click for set username input");
		ezUsernames3.setText("johannes");
		ezUsernames3.setEditable(false);
		ezUsernames3.setColumns(10);
		ezUsernames3.setBounds(410, 348, 114, 19);
		add(ezUsernames3);
		
		ezUsernames4 = new JTextField();
		ezUsernames4.setToolTipText("Click for set username input");
		ezUsernames4.setText("huseyin");
		ezUsernames4.setEditable(false);
		ezUsernames4.setColumns(10);
		ezUsernames4.setBounds(537, 348, 114, 19);
		add(ezUsernames4);
		
		ezUsernames5 = new JTextField();
		ezUsernames5.setToolTipText("Click for set username input");
		ezUsernames5.setText("tennant");
		ezUsernames5.setEditable(false);
		ezUsernames5.setColumns(10);
		ezUsernames5.setBounds(663, 348, 114, 19);
		add(ezUsernames5);
		
		JLabel ezUsernamesLabel = new JLabel("Valid Usernames:");
		ezUsernamesLabel.setBounds(158, 321, 398, 15);
		add(ezUsernamesLabel);
		
		JLabel ezPasswordLabel = new JLabel("Password:");
		ezPasswordLabel.setBounds(158, 379, 145, 15);
		add(ezPasswordLabel);
		
		ezPassword = new JTextField();
		ezPassword.setToolTipText("Click for set username password");
		ezPassword.setText("123456");
		ezPassword.setEditable(false);
		ezPassword.setColumns(10);
		ezPassword.setBounds(158, 406, 114, 19);
		add(ezPassword);
		
		lblYouCanSelect = new JLabel("Note: You can select inputs or click them to set set username/password input.");
		lblYouCanSelect.setForeground(Color.BLUE);
		lblYouCanSelect.setBounds(158, 446, 619, 15);
		add(lblYouCanSelect);
		
		// NOTE: THOSE ARE FOR EASY TESTING!
		ezUsernames1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setText(ezUsernames1.getText());
			}
		});
		ezUsernames2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setText(ezUsernames2.getText());
			}
		});
		ezUsernames3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setText(ezUsernames3.getText());
			}
		});
		ezUsernames4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setText(ezUsernames4.getText());
			}
		});
		ezUsernames5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setText(ezUsernames5.getText());
			}
		});
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
	private JTextField ezUsernames1;
	private JTextField ezUsernames2;
	private JTextField ezUsernames3;
	private JTextField ezUsernames4;
	private JTextField ezUsernames5;
	private JTextField ezPassword;
	private JLabel lblYouCanSelect;
}
