package tr.edu.iztech.lol.data;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

/*
 * Database interface that returns repository instances
 */
public interface IDatabase {
	IRepository<MatchRecord> getMatchRecordRepository();
	IRepository<User> getUserRepository();
	IRepository<String> getDescriptionRepository();
	void save();
}
