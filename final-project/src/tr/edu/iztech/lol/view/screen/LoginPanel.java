package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import tr.edu.iztech.lol.controller.ILoginController;

import javax.swing.JSeparator;

public class LoginPanel extends JPanel implements ILoginPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private final JLabel username1Label;
	private final JTextField username2Input;
	private final JTextField username1Input;
	private final JButton loginButton;
	private final JLabel messageLabel;
	
	public LoginPanel() {
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		username1Label = new JLabel("Username 1");
		username1Label.setBounds(190, 145, 100, 20);
		add(username1Label);
		
		username1Input = new JTextField();
		username1Input.setColumns(10);
		username1Input.setBounds(140, 170, 200, 20);
		add(username1Input);
		
		JLabel username2Label = new JLabel("Username 2");
		username2Label.setBounds(670, 145, 100, 20);
		add(username2Label);
		
		username2Input = new JTextField();
		username2Input.setColumns(10);
		username2Input.setBounds(620, 170, 200, 20);
		add(username2Input);
		
		loginButton = new JButton("Start");
		loginButton.setBounds(331, 585, 300, 47);
		add(loginButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(480, 0, 1, 550);
		add(separator);
		
		messageLabel = new JLabel("");
		messageLabel.setForeground(Color.RED);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(165, 558, 655, 15);
		add(messageLabel);
		
	}
	
	@Override
	public String getFirstUsername() {
		return username1Input.getText();
	}
	
	@Override
	public String getSecondUsername() {
		return username2Input.getText();
	}
	
	public void showError(String message) {
		messageLabel.setText(message);
	}
	
	public void hideError() {
		messageLabel.setText("");
	}

	@Override
	public void addLoginButtonListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
}
