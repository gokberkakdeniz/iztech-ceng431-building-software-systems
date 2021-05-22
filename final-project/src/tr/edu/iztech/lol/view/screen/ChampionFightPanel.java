package tr.edu.iztech.lol.view.screen;

import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Color;

import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.utils.IObserver;
import tr.edu.iztech.lol.view.component.ChampionFightComponent;

import javax.swing.JSeparator;

public class ChampionFightPanel extends JPanel implements IChampionFightPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private Match model;
	private ChampionFightComponent fightLeft;
	private ChampionFightComponent figthRight;
	
	public ChampionFightPanel(Match model) {
		this.model = model;
		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator horizontalSeparator = new JSeparator();
		horizontalSeparator.setForeground(Color.DARK_GRAY);
		horizontalSeparator.setBounds(0, 430, 960, 1);
		add(horizontalSeparator);

		
		fightLeft = new ChampionFightComponent(model.getUserLeft(), model.getHeroLeft());
		fightLeft.setBounds(0,0, 480, 430);
		add(fightLeft);
		
		figthRight = new ChampionFightComponent(model.getUserRight(), model.getHeroRight(), true);
		figthRight.setBounds(480,0, 480, 430);
		add(figthRight);
		
		String[] logs = {"şasdlfkadşflklşadfkg", "lkjsafglkajfdglakdfjg"};
        JList<String> list = new JList<>(logs);
        list.setBackground(new Color(0, 0, 0, 0));
        list.setBounds(10, 440, 940, 270);
        add(list);
	}

	@Override
	public void update() {
		fightLeft.update();
	}
}
