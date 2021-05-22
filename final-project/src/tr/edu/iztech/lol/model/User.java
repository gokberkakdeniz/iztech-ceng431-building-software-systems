package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tr.edu.iztech.lol.utils.AbstractObservable;

public class User extends AbstractObservable<User> implements IModel<User> {
	private String username;
	private List<Long> matchRecordIds;
	
	public User(String username) {
		this.username = username;
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
}