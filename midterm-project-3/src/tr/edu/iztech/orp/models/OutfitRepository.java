package tr.edu.iztech.orp.models;

import tr.edu.iztech.orp.data.IDataLoader;
import tr.edu.iztech.orp.data.OutfitSaver;
import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;

public class OutfitRepository extends AbstractOutfitContainer<OutfitRepository, OutfitRepositoryEvent> {
	public OutfitRepository(IDataLoader<Outfit> dataLoader, OutfitSaver outfitSaver) {
		super();
		dataLoader.load().forEach(this::add);
//		outfitSaver.save(getAll());
	}
}
