package tr.edu.iztech.orp.views;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = -3203330751289409445L;
	
	public HeaderPanel(ItemListener navigationListener, ActionListener logoutHandler) {		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JComboBox<MenuModel> viewCombo = new JComboBox<MenuModel>();
		viewCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(event);
					
					navigationListener.itemStateChanged(event);
				}
			}
		});
		viewCombo.setModel(new DefaultComboBoxModel<>(MenuModel.publicValues()));
		add(viewCombo);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(logoutHandler);
		add(logoutButton);
	}
}
