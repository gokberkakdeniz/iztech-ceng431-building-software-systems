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
		int winCount = jsonField.getInt("winCount");
		int loseCount = jsonField.getInt("loseCount");
		JSONArray matchRecordsArray = jsonField.getJSONArray("matchRecords");
		
		User tempUser = new User(username, winCount, loseCount);
		
		for(int i = 0; i < matchRecordsArray.length(); ++i) {
			tempUser.addMatchRecord(matchRecordsArray.getLong(i));
		}
		
		return tempUser;
	}
}
