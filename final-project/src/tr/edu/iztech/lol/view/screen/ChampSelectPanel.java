package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

import tr.edu.iztech.lol.view.component.ChampSelectComponent;

import javax.swing.JSeparator;

public class ChampSelectPanel extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	public ChampSelectPanel() {		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(480, 0, 1, 720);
		add(separator);
		
		ChampSelectComponent user1 = new ChampSelectComponent();
		user1.setBounds(0,0, 480, 720);
		
		ChampSelectComponent user2 = new ChampSelectComponent();
		user2.setBounds(480,0, 480, 720);
		
		add(user1);
		add(user2);

		
	}
}
