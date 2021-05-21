package tr.edu.iztech.lol.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;

public class MatchRecordSaver implements IDataSaver<MatchRecord> {
	private final File file;
	private final ISerizalizer<MatchRecord> serizalizer;
	
	public MatchRecordSaver(File file, ISerizalizer<MatchRecord> serizalizer) {
		this.file = file;
		this.serizalizer = serizalizer;
	}
	
	@Override
	public void save(List<MatchRecord> data) {
		// TODO Auto-generated method stub
		
	}

}
