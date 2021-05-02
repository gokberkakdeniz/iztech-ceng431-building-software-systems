package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.orp.enums.OutfitColor;
import tr.edu.iztech.orp.enums.OutfitGender;
import tr.edu.iztech.orp.enums.OutfitOccasion;
import tr.edu.iztech.orp.enums.OutfitSize;
import tr.edu.iztech.orp.enums.OutfitType;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;

public class UserLoader implements IDataLoader<User> {
	private final File file;
	
	public UserLoader(String pathname) {
		this.file = new File(pathname);
	}
	
	public UserLoader(File file) {
		this.file = file;
	}
	
	@Override
	public List<User> load() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User("",""));
		users.add(new User("a","a"));
		OutfitCollection col1 = new OutfitCollection("col1");
		OutfitCollection col2 = new OutfitCollection("col2");
		OutfitCollection col3 = new OutfitCollection("col3");

		col1.add(new Outfit(1, "Tshirt", "DeFacto", OutfitGender.MAN, OutfitType.TSHIRT, OutfitOccasion.SPORTY, OutfitColor.BLACK, new OutfitSize[] { OutfitSize.XXXXXL, OutfitSize.M }));
		col1.add(new Outfit(2, "Tshirt", "Koton", OutfitGender.UNISEX, OutfitType.TSHIRT, OutfitOccasion.CASUAL, OutfitColor.YELLOW, new OutfitSize[] { OutfitSize.S, OutfitSize.M }));
		
		users.get(0).addCollection(col1);
		users.get(0).addCollection(col2);
		users.get(1).addCollection(col3);
		
		users.get(0).follow(users.get(1));
		users.get(1).followedBy(users.get(0));

		return users;
	}

}
