package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.UserRepository;
import tr.edu.iztech.orp.utils.IEvent;

public enum UserRepositoryEvent implements IEvent<UserRepository> {
	ADDED,
	REMOVED;

	private UserRepository subject;
	
	@Override
	public UserRepositoryEvent withSubject(UserRepository subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public UserRepository getSubject() {
		return subject;
	}
}
