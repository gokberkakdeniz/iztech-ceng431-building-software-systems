package tr.edu.iztech.orp.models;

import java.util.HashSet;
import java.util.Set;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.utils.AbstractObservable;

public class OutfitCollection extends AbstractObservable<OutfitCollection, OutfitCollectionEvent>  {
	private String name;
	private Set<Outfit> productIds;
	
	public OutfitCollection(String name) {
		this.name = name;
		this.productIds = new HashSet<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean addOutfit(Outfit outfit) {
		boolean result = productIds.add(outfit);
		if (result) notifySubscribers(OutfitCollectionEvent.ADD_OUTFIT);
		return result;
	}
	
	public boolean removeOutfit(Outfit outfit) {
		boolean result = productIds.remove(outfit);
		if (result) notifySubscribers(OutfitCollectionEvent.REMOVE_OUTFIT);
		return result;
	}
}
