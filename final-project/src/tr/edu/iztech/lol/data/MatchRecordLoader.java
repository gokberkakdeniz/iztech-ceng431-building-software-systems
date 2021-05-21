package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

public class MatchRecordLoader implements IDataLoader<MatchRecord> {
	private final File file;
	private final IDeserializer<MatchRecord> deserializer;
	
	public MatchRecordLoader(File file, IDeserializer<MatchRecord> deserializer) {
		this.deserializer = deserializer;
		this.file = file;
	}
	
	@Override
	public List<MatchRecord> load() {
		return new ArrayList<>();
	}

}
