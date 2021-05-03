package tr.edu.iztech.orp.models;

import tr.edu.iztech.orp.data.IDataLoader;
import tr.edu.iztech.orp.data.IDataSaver;
import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;

public class OutfitRepository extends AbstractOutfitContainer<OutfitRepository, OutfitRepositoryEvent> {
	private final IDataSaver<Outfit> dataSaver;
	
	public OutfitRepository(IDataLoader<Outfit> dataLoader, IDataSaver<Outfit> dataSaver) {
		super();
		dataLoader.load().forEach(this::add);
		this.dataSaver = dataSaver;
	}

	@Override
	public void save() {
		dataSaver.save(getAll());		
	}
}
