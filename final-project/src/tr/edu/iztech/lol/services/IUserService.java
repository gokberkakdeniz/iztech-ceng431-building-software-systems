package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.model.Session;

public interface IUserService {
	IResponse<Session, ?> login(String username1, String username2);
}
