package tr.edu.iztech.lol.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.*;

import tr.edu.iztech.lol.model.User;

public class UserSaver implements IDataSaver<User> {
	private final File file;
	
	public UserSaver(File file) {
		this.file = file;
	}
	
	@Override
	public void save(List<User> data) {
		JSONArray list = new JSONArray();

		JSONObject userObject;
		for(User user: data) {
			userObject = serialize(user);
			list.put(userObject);
		}
		
		try {
			FileWriter myFile = new FileWriter(file);
			myFile.write(list.toString(2));
			myFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private JSONObject serialize(User user) {
		JSONObject userObject = new JSONObject();
		
		userObject.put("matchRecords", user.getMatchRecordIds());
		userObject.put("username", user.getUsername());
		userObject.put("winCount", user.getWinCount());
		userObject.put("loseCount", user.getLoseCount());


		return userObject;
	}

}
