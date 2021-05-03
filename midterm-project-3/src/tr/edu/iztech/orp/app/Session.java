package tr.edu.iztech.orp.app;

import tr.edu.iztech.orp.data.IStatistics;
import tr.edu.iztech.orp.models.User;

/**
 * Session container
 */
public class Session {
	private static User user;
	private static IStatistics statistics;
	
	public static void setStatistics(IStatistics statistics) {
		Session.statistics = statistics;
	}
	
	public static IStatistics getStatistics() {
		return statistics;
	}
	
	public static User getUser() {
		return user;
	}
	
	public static void setUser(User user) {
		Session.user = user;
	}
}
