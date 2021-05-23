package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.lol.utils.AbstractObservable;

public class TopWinnersModel extends AbstractObservable<TopWinnersModel>{
	private List<User> topWinners;
	
	public TopWinnersModel(List<User> topWinners) {
		this.topWinners = topWinners;
	}
	
	public ArrayList<User> getTopWinners() {
		return new ArrayList<User>(topWinners);
	}
}
