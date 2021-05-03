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
	
	private Outfit subject;
	
	public OutfitEvent withSubject(Outfit subject) {
		this.subject = subject;
		return this;
	}
	
	public boolean hasSubject() {
		return subject != null;
	}
	
	public Outfit getSubject() {
		return subject;
	}
}
