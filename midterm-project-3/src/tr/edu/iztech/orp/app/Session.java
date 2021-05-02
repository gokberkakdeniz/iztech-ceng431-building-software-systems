package tr.edu.iztech.orp.app;

import tr.edu.iztech.orp.models.User;

public class Session {
	private static User user;
	
	public static User getUser() {
		return user;
	}
	
	public static void setUser(User user) {
		Session.user = user;
	}
}
