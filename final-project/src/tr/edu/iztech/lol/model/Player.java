package tr.edu.iztech.lol.model;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.IState;

public class Player  {
	private String username;
	private String heroName;
	private IState startStatistic;
	private IState endStatistic;
	
	public Player(String username, IHero hero, IState startStatistic) {
		this.username = username;
		this.heroName = hero.getName();
		this.startStatistic = startStatistic;
		this.endStatistic = hero.getState();
	}
	
	public Player(String username, String heroName, IState startStatistic, IState endStatistic) {
		this.username = username;
		this.heroName = heroName;
		this.startStatistic = startStatistic;
		this.endStatistic = endStatistic;
	}
	
	public String getHeroName() {
		return heroName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public IState getStartStatistic() {
		return startStatistic.clone();
	}
	
	public IState getEndStatistic() {
		return endStatistic.clone();
	}
}