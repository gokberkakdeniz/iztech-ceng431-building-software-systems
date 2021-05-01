package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.orp.enums.OutfitColor;
import tr.edu.iztech.orp.enums.OutfitGender;
import tr.edu.iztech.orp.enums.OutfitSize;
import tr.edu.iztech.orp.enums.OutfitType;
import tr.edu.iztech.orp.models.Outfit;

public class OutfitLoader implements IDataLoader<Outfit> {
	private final File file;
	
	public OutfitLoader(String pathname) {
		this.file = new File(pathname);
	}
	
	public OutfitLoader(File file) {
		this.file = file;
	}
	
	@Override
	public List<Outfit> load() {
		List<Outfit> outfits = new ArrayList<>();
		
		outfits.add(new Outfit(1, "Tshirt", "DeFacto", OutfitGender.MAN, OutfitType.SPORTY, OutfitColor.BLACK, new OutfitSize[] { OutfitSize.XXXXXL, OutfitSize.M }));
		
		return outfits;
	}
}
