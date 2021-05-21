package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

public class MatchRecordLoader implements IDataLoader<MatchRecord> {
	private final File file;
	
	public MatchRecordLoader(File file) {
		this.file = file;
	}
	
	@Override
	public List<MatchRecord> load() {
		return new ArrayList<>();
	}

}
