package tr.edu.iztech.lol.model;

import tr.edu.iztech.lol.utils.AbstractObservable;

public class ChampionSelectModel extends AbstractObservable<ChampionSelectModel> implements IModel<ChampionSelectModel>  {
	private User user;
	private AvailableChampions availableChampions;
	private String selectedOrigin;
	private String selectedHero;
	
	public ChampionSelectModel(User user, AvailableChampions availableChampions) {
		this.availableChampions = availableChampions;
		this.selectedOrigin = availableChampions.getOriginNames().get(0);
		this.selectedHero = availableChampions.getHeroNames().get(0);
		this.user = user;
	}
	
	public AvailableChampions getAvailableChampions() {
		return availableChampions;
	}
	
	public String getSelectedOrigin() {
		return selectedOrigin;
	}
	
	public String getSelectedHero() {
		return selectedHero;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setSelectedHero(String selectedHero) {
		this.selectedHero = selectedHero;
		notifySubscribers();
	}
	
	public void setSelectedOrigin(String selectedOrigin) {
		this.selectedOrigin = selectedOrigin;
		notifySubscribers();
	}
}
