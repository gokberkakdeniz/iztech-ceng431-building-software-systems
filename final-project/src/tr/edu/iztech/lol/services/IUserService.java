package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.exception.UserNotFoundException;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.model.User;

public interface IUserService {
	IResponse<Session, ?> login(String username1, String username2);
}
