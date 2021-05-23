package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tr.edu.iztech.lol.utils.AbstractObservable;

public class User extends AbstractObservable<User> implements IModel<User> {
	private String username;
	private int winCount;
	private int loseCount;
	private List<Long> matchRecordIds;
	
	public User(String username) {
		this(username, 0 ,0);
	}
	
	public User(String username, int winCount, int loseCount) {
		this.username = username;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.matchRecordIds = new LinkedList<>();
	}
	
	public List<Long> getMatchRecordIds() {
		return new ArrayList<>(matchRecordIds);
	}
	
	public void addMatchRecord(Long id) {
		matchRecordIds.add(id);
		notifySubscribers();
	}
	
	public void addMatchRecord(MatchRecord matchRecord) {
		addMatchRecord(matchRecord.getId());
	}
	
	public String getUsername() {
		return username;
	}

	public int getLoseCount() {
		return loseCount;
	}

	public void increaseLoseCount() {
		loseCount++;
	}

	public int getWinCount() {
		return winCount;
	}

	public void increaseWinCount() {
		winCount++;
	}
	
	public double getWinRate() {
		return loseCount != 0 ? ((double) winCount) / loseCount: winCount;
	}
}