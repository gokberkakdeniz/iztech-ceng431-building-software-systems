package tr.edu.iztech.lol.data;

import tr.edu.iztech.lol.model.Session;

/**
 * Stores current session
 */
public interface ISessionContainer {
	void setSession(Session session);
	Session getSession();
}
