package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Color;
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
	
	public ChampionFightComponent(User user, IHero hero) {		
		this(user, hero, false);
	}
	
	public ChampionFightComponent(User user, IHero hero, boolean rightToLeft) {
		this.hero = hero;
		
		setLayout(null);
		setBounds(0,0, 480, 430);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(10, 50, 460, 25);
		add(progressBar);
		
		JLabel nameLabel = new JLabel(String.format("%s's %s", user.getUsername(), hero.getName()));
		nameLabel.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		nameLabel.setBounds(20, 10, 440, 30);
		
		add(nameLabel);
		
		healthLabel = new JLabel();
		healthLabel.setBounds(20, 100, 440, 20);
		healthLabel.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 16));
		add(healthLabel);
		
		attackDamageLabel = new JLabel();
		attackDamageLabel.setBounds(20, 140, 440, 20);
		attackDamageLabel.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 16));
		add(attackDamageLabel);
		
		criticalChanceLabel = new JLabel();
		criticalChanceLabel.setBounds(20, 180, 440, 20);
		criticalChanceLabel.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 16));
		add(criticalChanceLabel);
		
		if(rightToLeft) {
			progressBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			healthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			attackDamageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			criticalChanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		update();
	}
	
	public void update() {
		int hp = hero.getHealthPercentage();
		progressBar.setValue(hp);
		
		if (hp < 30) {
			progressBar.setForeground(Color.RED);
		} else if (hp < 50) {
			progressBar.setForeground(Color.ORANGE);
		} else if (hp < 70) {
			progressBar.setForeground(Color.YELLOW);
		} 
		
		healthLabel.setText(String.format("Health Point: %d", hero.getHealthPoint()));
		attackDamageLabel.setText(String.format("Attack Damage: %d", hero.getState().getAttackDamage()));
		criticalChanceLabel.setText(String.format("Critical Chance: %.2f", hero.getState().getCriticalChance()));
	}
}
