package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(file);
			
			document.getDocumentElement().normalize();
			NodeList userList = (NodeList) document.getDocumentElement();
//			NodeList userList = document.getElementsByTagName("users");
			
			for(int i = 0; i < userList.getLength(); ++i) {
				Node node = userList.item(i);
				System.out.println(node.getTextContent());
			}
			
						 
//			System.out.println(root.getElementsByTagName("users"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		users.add(new User("",""));
//		users.add(new User("a","a"));
//		users.add(new User("b","b"));
//		OutfitCollection col1 = new OutfitCollection("col1");
//		OutfitCollection col2 = new OutfitCollection("col2");
//		OutfitCollection col3 = new OutfitCollection("col3");
//
//		col1.add(new Outfit(1, "Tshirt", "DeFacto", OutfitGender.MAN, OutfitType.TSHIRT, OutfitOccasion.SPORTY, OutfitColor.BLACK, new OutfitSize[] { OutfitSize.XXXXXL, OutfitSize.M }));
//		col1.add(new Outfit(2, "Tshirt", "Koton", OutfitGender.UNISEX, OutfitType.TSHIRT, OutfitOccasion.CASUAL, OutfitColor.YELLOW, new OutfitSize[] { OutfitSize.S, OutfitSize.M }));
//		
//		col3.add(new Outfit(1, "Tshirt", "DeFacto", OutfitGender.MAN, OutfitType.TSHIRT, OutfitOccasion.SPORTY, OutfitColor.BLACK, new OutfitSize[] { OutfitSize.XXXXXL, OutfitSize.M }));
//		col3.add(new Outfit(2, "Tshirt", "Koton", OutfitGender.UNISEX, OutfitType.TSHIRT, OutfitOccasion.CASUAL, OutfitColor.YELLOW, new OutfitSize[] { OutfitSize.S, OutfitSize.M }));
//		
//		users.get(0).addCollection(col1);
//		users.get(0).addCollection(col2);
//		users.get(1).addCollection(col3);
//		
//		users.get(0).follow(users.get(1));
//		users.get(1).followedBy(users.get(0));

		return users;
	}

}
