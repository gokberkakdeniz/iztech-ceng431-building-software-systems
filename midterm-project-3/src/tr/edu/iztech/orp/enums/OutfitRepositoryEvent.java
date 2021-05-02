package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.utils.IEvent;

public enum OutfitRepositoryEvent implements IEvent<OutfitRepository> {
	ADD_OUTFIT,
	REMOVE_OUTFIT;
}
