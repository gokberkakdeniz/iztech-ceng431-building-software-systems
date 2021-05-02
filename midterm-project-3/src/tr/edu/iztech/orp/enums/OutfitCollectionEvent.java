package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.utils.IEvent;

public enum OutfitCollectionEvent implements IEvent<OutfitCollection> {
	ADD_OUTFIT,
	REMOVE_OUTFIT,
	RENAME;
}
