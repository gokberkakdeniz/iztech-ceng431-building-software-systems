package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.lol.model.User;

public class UserLoader implements IDataLoader<User> {
	private final File file;
	private final IDeserializer<User> deserializer;
	
	public UserLoader(File file, IDeserializer<User> deserializer) {
		this.file = file;
		this.deserializer = deserializer;
	}
	
	@Override
	public List<User> load() {
		return new ArrayList<>();
	}

}
