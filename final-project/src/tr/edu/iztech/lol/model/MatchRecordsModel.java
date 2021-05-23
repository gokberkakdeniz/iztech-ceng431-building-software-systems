package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.lol.utils.AbstractObservable;

public class MatchRecordsModel extends AbstractObservable<MatchRecordsModel>{
	private List<MatchRecord> matchRecords;
	
	public MatchRecordsModel() {
		this.matchRecords = new ArrayList<MatchRecord>();
	}
	
	public void setMatchRecords(List<MatchRecord> records) {
		this.matchRecords = records;
		notifySubscribers();
	}
	
	public void addMatchRecord(MatchRecord record) {
		matchRecords.add(record);
		notifySubscribers();
	}
	
	public ArrayList<MatchRecord> getMatchRecords() {
		return new ArrayList<MatchRecord>(matchRecords);
	}
	
}
