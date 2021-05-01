package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.orp.models.User;

public class UserLoader implements IDataLoader<User> {
	private final File file;
	
	public UserLoader(String pathname) {
		this.file = new File(pathname);
	}
	
	public UserLoader(File file) {
		this.file = file;
	}
	
	@Override
	public List<User> load() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User("",""));
		users.add(new User("a","a"));
		
		return users;
	}

}
