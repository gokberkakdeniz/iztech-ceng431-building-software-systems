package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.utils.IEvent;

public enum OutfitEvent implements IEvent<Outfit> {
	LIKE,
	REMOVE_LIKE,
	DISLIKE,
	REMOVE_DISLIKE,
	ADD_COMMENT,
	REMOVE_COMMENT;
}
