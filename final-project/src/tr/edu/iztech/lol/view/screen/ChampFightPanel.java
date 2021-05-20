package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.SwingConstants;

import tr.edu.iztech.lol.view.component.ChampFightComponent;

import javax.swing.JSeparator;

public class ChampFightPanel extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	public ChampFightPanel() {		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator horizontalSeparator = new JSeparator();
		horizontalSeparator.setForeground(Color.DARK_GRAY);
		horizontalSeparator.setBackground(Color.DARK_GRAY);
		horizontalSeparator.setBounds(0, 430, 960, 1);
		add(horizontalSeparator);

		
		ChampFightComponent user1 = new ChampFightComponent();
		user1.setBounds(0,0, 480, 430);
		
		ChampFightComponent user2 = new ChampFightComponent();
		user2.setBounds(480,0, 480, 430);
		add(user1);
		add(user2);
		
	}
}
