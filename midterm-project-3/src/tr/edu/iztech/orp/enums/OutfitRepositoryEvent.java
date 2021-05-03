package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.utils.IEvent;

public enum OutfitRepositoryEvent implements IEvent<OutfitRepository> {
	ADD_OUTFIT,
	REMOVE_OUTFIT;
	
	private OutfitRepository subject;
	
	@Override
	public OutfitRepositoryEvent withSubject(OutfitRepository subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public OutfitRepository getSubject() {
		return subject;
	}
}
