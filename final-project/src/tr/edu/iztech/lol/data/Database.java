package tr.edu.iztech.lol.data;

import java.io.File;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

/**
 * Database class with Singleton design pattern
 */
public class Database implements IDatabase {
	private static IDatabase instance;
	private final IRepository<MatchRecord> matchRecordRepository;
	private final IRepository<User> userRepository;
	private final IRepository<String> descriptionRepository;
	private static File matchRecordsFile = new File("matchRecords.json");
	private static File usersFile = new File("users.json");
	
	private Database() {
		IDataLoader<MatchRecord> matchRecordLoader = new MatchRecordLoader(matchRecordsFile);
		IDataSaver<MatchRecord> matchRecordSaver = new MatchRecordSaver(matchRecordsFile);
		matchRecordRepository = new MatchRecordRepository(matchRecordLoader, matchRecordSaver);
		
		IDataLoader<User> userLoader = new UserLoader(usersFile);
		IDataSaver<User> userSaver = new UserSaver(usersFile);
		userRepository = new UserRepository(userLoader, userSaver);
		
		descriptionRepository = new DescriptionRepository();
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

	@Override
	public IRepository<String> getDescriptionRepository() {
		return this.descriptionRepository;
	}

	@Override
	public void save() {
		matchRecordRepository.save();		
		userRepository.save();
		descriptionRepository.save();
	}

}
