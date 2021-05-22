package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import java.awt.Color;
import tr.edu.iztech.lol.view.component.ChampionFightComponent;

import javax.swing.JSeparator;

public class ChampionFightPanel extends JPanel implements IChampionFightPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	public ChampionFightPanel() {		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator horizontalSeparator = new JSeparator();
		horizontalSeparator.setForeground(Color.DARK_GRAY);
		horizontalSeparator.setBackground(Color.DARK_GRAY);
		horizontalSeparator.setBounds(0, 430, 960, 1);
		add(horizontalSeparator);

		
		ChampionFightComponent user1 = new ChampionFightComponent();
		user1.setBounds(0,0, 480, 430);
		
		ChampionFightComponent user2 = new ChampionFightComponent(true);
		user2.setBounds(480,0, 480, 430);
		add(user1);
		add(user2);
		
	}
}
