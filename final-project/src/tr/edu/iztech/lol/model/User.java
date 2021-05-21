package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User implements IModel {
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
	}
	
	public void addMatchRecord(MatchRecord matchRecord) {
		addMatchRecord(matchRecord.getId());
	}
	
	public String getUsername() {
		return username;
	}
}