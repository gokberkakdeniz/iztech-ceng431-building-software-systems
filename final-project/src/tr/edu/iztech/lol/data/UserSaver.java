package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

public class UserSaver implements IDataSaver<User> {
	private final File file;
	private final ISerizalizer<User> serizalizer;
	
	public UserSaver(File file, ISerizalizer<User> serizalizer) {
		this.file = file;
		this.serizalizer = serizalizer;
	}
	
	@Override
	public void save(List<User> data) {
		// TODO Auto-generated method stub
		
	}

}
