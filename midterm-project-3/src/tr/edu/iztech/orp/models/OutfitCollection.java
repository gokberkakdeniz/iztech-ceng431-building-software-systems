package tr.edu.iztech.orp.models;

import java.util.HashSet;
import java.util.Set;

public class OutfitCollection {
	private String name;
	private Set<Integer> productIds;
	
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
		return productIds.add(outfit.getId());
	}
	
	public boolean removeOutfit(Outfit outfit) {
		return productIds.remove(outfit.getId());
	}
}
