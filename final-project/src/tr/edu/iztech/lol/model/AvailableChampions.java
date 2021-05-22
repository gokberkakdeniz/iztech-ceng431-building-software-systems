package tr.edu.iztech.lol.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvailableChampions {
	private Map<String, String> availableHeros;
	private Map<String, String> availableOrigins;
	
	public AvailableChampions() {
		availableHeros = new HashMap<>();
		availableOrigins = new HashMap<>();
	}
	
	public void addHero(String name, String description) {
		availableHeros.put(name, description);
	}
	
	public void addOrigin(String name, String description) {
		availableOrigins.put(name, description);
	}
	
	public List<String> getHeroNames() {
		return new ArrayList<>(availableHeros.keySet());
	}
	
	public List<String> getOriginNames() {
		return new ArrayList<>(availableOrigins.keySet());
	}
	
	public String getOriginDescription(String name) {
		return availableOrigins.get(name);
	}
	
	public String getHeroDescription(String name) {
		return availableHeros.get(name);
	}
}
