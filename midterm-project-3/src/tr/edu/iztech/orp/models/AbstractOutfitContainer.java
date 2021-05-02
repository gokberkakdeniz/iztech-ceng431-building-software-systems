package tr.edu.iztech.orp.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.orp.utils.AbstractObservable;
import tr.edu.iztech.orp.utils.IEvent;

public abstract class AbstractOutfitContainer<T, K extends IEvent<T>>
	extends AbstractObservable<T, K> 
	implements IRepository<Outfit> 
{
	private final List<Outfit> outfits;
	
	public AbstractOutfitContainer() {
		this.outfits = new LinkedList<>();
	}

	@Override
	public Optional<Outfit> get(Object id) {
		return outfits.stream().filter(u -> (Integer) u.getId() == id).findFirst();
	}

	@Override
	public Optional<Outfit> get(Predicate<Outfit> predicate) {
		return outfits.stream().filter(predicate).findFirst();
	}

	@Override
	public List<Outfit> getAll() {
		return new ArrayList<>(outfits);
	}

	@Override
	public List<Outfit> getAll(Predicate<Outfit> predicate) {
		return outfits.stream().filter(predicate).collect(Collectors.toList());
	}
	
	public boolean add(Outfit outfit) {
		return outfits.add(outfit);
	}
	
	public boolean remove(Outfit outfit) {
		return outfits.remove(outfit);
	}
}
