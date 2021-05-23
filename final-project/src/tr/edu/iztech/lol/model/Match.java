package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.utils.AbstractObservable;
import tr.edu.iztech.lol.utils.IObserver;

public class Match extends AbstractObservable<Match> implements IModel<Match> {
	private User userLeft;
	private IHero heroLeft;
	private User userRight;
	private IHero heroRight;
	private List<String> logs;
	
	public Match(User userLeft, IHero heroLeft, User userRight, IHero heroRight) {
		this.userLeft = userLeft;
		this.heroLeft = heroLeft;
		this.userRight = userRight;
		this.heroRight = heroRight;
		this.logs = new LinkedList<String>();
	}
	
	public User getUserLeft() {
		return userLeft;
	}
	
	public User getUserRight() {
		return userRight;
	}
	
	public IHero getHeroLeft() {
		return heroLeft;
	}
	
	public IHero getHeroRight() {
		return heroRight;
	}
	
	public List<String> getLogs() {
		return new ArrayList<>(logs);
	}

	public void addLog(String log) {
		this.logs.add(log);
		notifySubscribers();
	}
	
	public boolean isFinished() {
		return getHeroLeft().getHealthPoint() <= 0 || getHeroRight().getHealthPoint() <= 0;
	}
	
	public IHero getWinner() {
		if (!isFinished()) return null;
		
		return getHeroLeft().getHealthPoint() > 0 ? getHeroLeft() : getHeroRight();
	}
	
	public User getWinnerUser() {
		if (!isFinished()) return null;
		
		return getHeroLeft().getHealthPoint() > 0 ? getUserLeft() : getUserRight();
	}
	
}
