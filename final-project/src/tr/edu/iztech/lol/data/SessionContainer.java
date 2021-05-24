package tr.edu.iztech.lol.data;

import tr.edu.iztech.lol.model.Session;

/**
 * SessionContainer class with Singleton design pattern
 */
public class SessionContainer implements ISessionContainer {
	private static ISessionContainer instance = null;
	private Session session = null;
	
	private SessionContainer() {}
	
	public static ISessionContainer getInstance() {
		if (instance == null) {
			instance = new SessionContainer();
		}
		
		return instance;
	}
	
	public void setSession(Session session) {
		this.session = session;
	};
	
	public Session getSession() { 
		return this.session; 
	};
}
