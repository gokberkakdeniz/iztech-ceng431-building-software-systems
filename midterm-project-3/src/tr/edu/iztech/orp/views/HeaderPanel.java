package tr.edu.iztech.orp.views;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import tr.edu.iztech.orp.models.User;

import javax.swing.JLabel;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = -3203330751289409445L;
	
	public HeaderPanel(IScreenManager screenManager, User user) {		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JComboBox<MenuModel> viewCombo = new JComboBox<MenuModel>();
		viewCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {		
					screenManager.onPageChanged((MenuModel)event.getItem());
				}
			}
		});
		
		JLabel usernameLabel = new JLabel("Welcome, " + user.getUsername() + "!");
		add(usernameLabel);
		viewCombo.setModel(new DefaultComboBoxModel<>(MenuModel.publicValues()));
		add(viewCombo);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(e -> screenManager.onLogout());
		add(logoutButton);
	}
}
