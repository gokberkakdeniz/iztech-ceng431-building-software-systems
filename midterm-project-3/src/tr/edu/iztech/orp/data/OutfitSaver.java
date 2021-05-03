package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.orp.models.Outfit;

public class OutfitSaver implements IDataSaver<Outfit> {
	private final File file;
	
	public OutfitSaver(String pathname) {
		this.file = new File(pathname);
	}

	@Override
	public void save(List<Outfit> data) {

	}
}
