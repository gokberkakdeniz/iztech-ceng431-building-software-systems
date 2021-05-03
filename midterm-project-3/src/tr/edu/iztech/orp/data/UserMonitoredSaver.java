package tr.edu.iztech.orp.data;

import java.util.stream.Stream;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;

public class UserMonitoredSaver implements IDataMonitoredSaver<User, UserEvent> {
	private final IRepository<User> userRepo;
	
	public UserMonitoredSaver(IRepository<User> userRepo) {
		this.userRepo = userRepo;
		
		userRepo.getAll().forEach(u -> {
			subscribeToAllEvents(u);
			
			u.getCollections().forEach(this::subscribeToAllEvents);
		});
	}

	@Override
	public void update(UserEvent event) {
		switch (event) {
			case ADD_COLLECTION:
				event.getSubject().getCollections().forEach(this::subscribeToAllEvents);
			default:
				userRepo.save();
				break;
		}
	}

	private void subscribeToAllEvents(User user) {
		Stream.of(UserEvent.values()).forEach(e -> user.subscribe(e, this));
	}
	
	private void subscribeToAllEvents(OutfitCollection outfitCollection) {
		Stream.of(OutfitCollectionEvent.values()).forEach(e -> outfitCollection.subscribe(e, userCollectionMonitoredSaver));
	}
	
	private IDataMonitoredSaver<OutfitCollection, OutfitCollectionEvent> userCollectionMonitoredSaver = new IDataMonitoredSaver<>() {
		@Override
		public void update(OutfitCollectionEvent event) {
			userRepo.save();
		}
	};
}
