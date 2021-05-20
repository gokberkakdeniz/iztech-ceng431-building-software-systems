package tr.edu.iztech.lol.data;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

public interface IDatabase {
	IRepository<MatchRecord> getMatchRecordRepository();
	IRepository<User> getUserRepository();
}
