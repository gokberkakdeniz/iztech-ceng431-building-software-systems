package tr.edu.iztech.lol.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

import tr.edu.iztech.lol.model.User;

public class UserLoader implements IDataLoader<User> {
	private final File file;
	
	public UserLoader(File file) {
		this.file = file;
	}
	
	@Override
	public List<User> load() {
		InputStream is = null;
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONTokener tokener = new JSONTokener(is);
        JSONArray object = new JSONArray(tokener);
        
		List<User> users = new ArrayList<>();

		for(Object obj: object) {
			users.add(deserialize(obj));
		}
		
		return users;
	}
	
	private User deserialize(Object user) {
		JSONObject jsonField = (JSONObject) user;
		
		String username = jsonField.getString("username");
		JSONArray matchRecordsArray = jsonField.getJSONArray("matchRecords");
		
		User tempUser = new User(username);

		for(Object size: matchRecordsArray) {
			tempUser.addMatchRecord(Long.valueOf((int) size));
		}
		
		return tempUser;
	}
}
