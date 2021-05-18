package tr.edu.iztech.lol.data;

public class Database implements IDatabase {
	private static IDatabase instance;
	private IRepository<Integer> integerRepository;
	
	private Database() {
		 
	}
	
	public static IDatabase getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		
		return instance;
	}

	@Override
	public IRepository<Integer> getIntegerRepository() {
		return this.integerRepository;
	}

}
