package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.lol.model.User;

public class UserSaver implements IDataSaver<User> {
	private final File file;
	
	public UserSaver(File file) {
		this.file = file;
	}
	
	@Override
	public void save(List<User> data) {
		// TODO Auto-generated method stub
		
	}

}
