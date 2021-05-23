package tr.edu.iztech.lol.model;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.IState;

public class Player {
	private String username;
	private String heroName;
	private IState endStatistic;
	
	public Player(String username, IHero hero) {
		this.username = username;
		this.heroName = hero.getName();
		this.endStatistic = hero.getState();
	}
	
	public Player(String username, String heroName, IState endStatistic) {
		this.username = username;
		this.heroName = heroName;
		this.endStatistic = endStatistic;
	}
	
	public String getHeroName() {
		return heroName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public IState getEndStatistic() {
		return endStatistic.clone();
	}
}