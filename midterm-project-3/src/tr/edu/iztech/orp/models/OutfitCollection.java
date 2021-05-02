package tr.edu.iztech.orp.models;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;

public class OutfitCollection extends AbstractOutfitContainer<OutfitCollection, OutfitCollectionEvent> implements Comparable<OutfitCollection> {
	private String name;

	public OutfitCollection(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		notifySubscribers(OutfitCollectionEvent.RENAME);
	}
	
	public boolean add(Outfit outfit) {
		boolean result = super.add(outfit);
		if (result) notifySubscribers(OutfitCollectionEvent.ADD_OUTFIT);
		return result;
	}
	
	public boolean remove(Outfit outfit) {
		boolean result = super.remove(outfit);
		if (result) notifySubscribers(OutfitCollectionEvent.REMOVE_OUTFIT);
		return result;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(OutfitCollection arg0) {
		return getName().compareTo(arg0.getName());
	}
}
