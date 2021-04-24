package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		JButton btnNewButton = new JButton("lp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton);
	}
}
