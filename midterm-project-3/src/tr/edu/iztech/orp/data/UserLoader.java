package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;

public class UserLoader implements IDataLoader<User> {
	private final File file;
	private final IRepository<Outfit> outfitRepository;
	
	public UserLoader(String pathname, IRepository<Outfit> outfitRepository) {
		this(new File(pathname), outfitRepository);
	}
	
	public UserLoader(File file, IRepository<Outfit> outfitRepository) {
		this.file = file;
		this.outfitRepository = outfitRepository;
	}
	
	@Override
	public List<User> load() {
		List<User> users = new ArrayList<User>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(file);
			
			document.getDocumentElement().normalize();
			
			Element root = document.getDocumentElement();
			
			NodeList userList = root.getElementsByTagName("user");
						
			for(int i = 0; i < userList.getLength(); ++i) {
                Node node = userList.item(i);
                Element eElement = (Element) node;
                String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                String password = eElement.getElementsByTagName("password").item(0).getTextContent();

                User tempUser = new User(username, password);
                
    			NodeList collectionList = eElement.getElementsByTagName("collection");
    			
    			for(int j = 0; j < collectionList.getLength(); ++j) {
    				Node collectionNode = collectionList.item(j);
                    Element cElement = (Element) collectionNode;
                    String name = cElement.getElementsByTagName("name").item(0).getTextContent();
                    
                    OutfitCollection tempCollection = new OutfitCollection(name);
                    
        			NodeList outfitList = cElement.getElementsByTagName("id");
        			for(int k = 0; k < outfitList.getLength(); ++k) {
        				String outfitId = outfitList.item(k).getTextContent();
        				tempCollection.add(outfitRepository.get(Integer.valueOf(outfitId)).get());
        			}
        			tempUser.addCollection(tempCollection);
    			}
    			users.add(tempUser);
            }
			
			for(int i = 0; i < userList.getLength(); ++i) {
				Node node = userList.item(i);
                Element eElement = (Element) node;
                
                Node followed = eElement.getElementsByTagName("followedUsers").item(0);
    			NodeList followedList = ((Element) followed).getElementsByTagName("id");
    			for(int j = 0; j < followedList.getLength(); ++j) {
    				String userId = followedList.item(j).getTextContent();
    				User followedUser = users.stream().filter(u -> userId.equals(u.getUsername())).findFirst().get();
    				users.get(i).follow(followedUser);
    			}
			}
				
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

}
