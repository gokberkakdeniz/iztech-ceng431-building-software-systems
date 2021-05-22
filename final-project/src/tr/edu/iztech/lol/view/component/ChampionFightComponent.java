package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.model.User;

public class ChampionFightComponent extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private JProgressBar progressBar;
	private JLabel healthLabel;
	private JLabel attackDamageLabel;
	private JLabel criticalChanceLabel;

	private IHero hero;
	private User user;
	
	public ChampionFightComponent(User user, IHero hero) {		
		this(user, hero, false);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public ChampionFightComponent(User user, IHero hero, boolean rightToLeft) {
		this.user = user;
		this.hero = hero;
		
		setLayout(null);
		setBounds(0,0, 480, 430);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 50, 460, 25);
		add(progressBar);
		
		progressBar.setComponentOrientation(rightToLeft ? ComponentOrientation.RIGHT_TO_LEFT : ComponentOrientation.LEFT_TO_RIGHT);
		
		JLabel nameLabel = new JLabel(user.getUsername());
		nameLabel.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		nameLabel.setBounds(10, 10, 460, 30);
		if(rightToLeft) {
			nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		add(nameLabel);
		
		healthLabel = new JLabel();
		healthLabel.setBounds(20, 98, 70, 15);
		add(healthLabel);
		
		attackDamageLabel = new JLabel();
		attackDamageLabel.setBounds(20, 98, 70, 15);
		add(attackDamageLabel);
		
		criticalChanceLabel = new JLabel();
		criticalChanceLabel.setBounds(20, 98, 70, 15);
		add(criticalChanceLabel);
		
		update();
	}
	
	public void update() {
		progressBar.setValue(hero.getHealthPercentage());
		healthLabel.setText(String.format("Health Point: %d", hero.getHealthPoint()));
		healthLabel.setText(String.format("Attack Damage: %d", hero.getState().getAttackDamage()));
		healthLabel.setText(String.format("Critical Chance: %f", hero.getState().getCriticalChance()));
	}
}
