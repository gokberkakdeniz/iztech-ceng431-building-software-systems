package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import tr.edu.iztech.lol.utils.AbstractObservable;

public class TopWinnersModel extends AbstractObservable<TopWinnersModel>{
	private List<User> topWinners;
	
	public TopWinnersModel() {
		this.topWinners = new ArrayList<User>();
	}
	
	public ArrayList<User> getTopWinners() {
		return new ArrayList<User>(topWinners);
	}
	
	public void addWinner(User user) {
		topWinners.add(user);
		topWinners.sort(Comparator.comparing(User::getWinRate).reversed());
		if(topWinners.size() > 10) {
			topWinners = topWinners.subList(0, 10);
		}
	}
}
