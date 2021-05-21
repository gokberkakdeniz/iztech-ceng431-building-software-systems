package tr.edu.iztech.lol.data;

import java.io.File;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

public class Database implements IDatabase {
	private static IDatabase instance;
	private final IRepository<MatchRecord> matchRecordRepository;
	private final IRepository<User> userRepository;
	private static File matchRecordsFile = new File("match_records.json");
	private static File usersFile = new File("users.json");
	
	private Database() {
		ISerizalizer<MatchRecord> matchRecordSerializer = new MatchRecordJsonSerizalizer();
		IDeserializer<MatchRecord> matchRecordDeserializer = new MatchRecordJsonDeserizalizer();
		IDataLoader<MatchRecord> matchRecordLoader = new MatchRecordLoader(matchRecordsFile, matchRecordDeserializer);
		IDataSaver<MatchRecord> matchRecordSaver = new MatchRecordSaver(matchRecordsFile, matchRecordSerializer);
		matchRecordRepository = new MatchRecordRepository(matchRecordLoader, matchRecordSaver);
		
		ISerizalizer<User> userSerializer = new UserJsonSerizalizer();
		IDeserializer<User> userDeserializer = new UserJsonDeserizalizer();
		IDataLoader<User> userLoader = new UserLoader(usersFile, userDeserializer);
		IDataSaver<User> userSaver = new UserSaver(usersFile, userSerializer);
		userRepository = new UserRepository(userLoader, userSaver);
	}
	
	public static IDatabase getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		
		return instance;
	}

	@Override
	public IRepository<MatchRecord> getMatchRecordRepository() {
		return this.matchRecordRepository;
	}

	@Override
	public IRepository<User> getUserRepository() {
		return this.userRepository;
	}

}
