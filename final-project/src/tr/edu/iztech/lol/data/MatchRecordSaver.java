package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;

public class MatchRecordSaver implements IDataSaver<MatchRecord> {
	private final File file;
	
	public MatchRecordSaver(File file) {
		this.file = file;
	}
	
	@Override
	public void save(List<MatchRecord> data) {
		// TODO Auto-generated method stub
		
	}

}
