package tr.edu.iztech.orp.enums;

import tr.edu.iztech.orp.models.UserRepository;
import tr.edu.iztech.orp.utils.IEvent;

public enum UserRepositoryEvent implements IEvent<UserRepository> {
	ADDED,
	REMOVED;
}
