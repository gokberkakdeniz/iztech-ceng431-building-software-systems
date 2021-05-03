package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.utils.IEvent;

public enum OutfitCollectionEvent implements IEvent<OutfitCollection> {
	ADD_OUTFIT,
	REMOVE_OUTFIT,
	RENAME;
	
	private OutfitCollection subject;
	
	@Override
	public OutfitCollectionEvent withSubject(OutfitCollection subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public OutfitCollection getSubject() {
		return subject;
	}
}
