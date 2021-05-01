package tr.edu.iztech.orp.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.orp.models.Outfit;

public class OutfitRepository implements IRepository<Outfit> {
	private List<Outfit> outfits;
	
	public OutfitRepository(IDataLoader<Outfit> dataLoader) {
		this.outfits = new LinkedList<>(dataLoader.load());
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
	

}
