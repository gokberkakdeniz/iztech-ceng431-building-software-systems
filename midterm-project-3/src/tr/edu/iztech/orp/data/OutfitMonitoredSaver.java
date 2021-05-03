package tr.edu.iztech.orp.data;

import java.util.stream.Stream;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;

public class OutfitMonitoredSaver implements IDataMonitoredSaver<Outfit, OutfitEvent> {
	private final IRepository<Outfit> userRepo;
	
	public OutfitMonitoredSaver(IRepository<Outfit> userRepo) {
		this.userRepo = userRepo;
		
		userRepo.getAll().forEach(this::subscribeToAllEvents);
	}

	@Override
	public void update(OutfitEvent event) {
		userRepo.save();
	}

	private void subscribeToAllEvents(Outfit outfit) {
		Stream.of(OutfitEvent.values()).forEach(e -> outfit.subscribe(e, this));
	}
}
