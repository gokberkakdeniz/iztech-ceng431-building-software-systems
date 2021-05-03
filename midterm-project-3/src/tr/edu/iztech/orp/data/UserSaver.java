package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.orp.models.User;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class UserSaver implements IDataSaver<User> {
    private File file;
    
	public UserSaver(String pathname) {
		super();
		this.file = new File(pathname);
	}
	
	@Override
	public void save(List<User> data) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElementNS("iztech:group6", "users");
	        doc.appendChild(root);
	        
	        for(User user: data) {
	            root.appendChild(user.serialize(doc));
	        }
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();

	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        DOMSource source = new DOMSource(doc);
	        StreamResult myFile = new StreamResult(file);
	        
	        transformer.transform(source, myFile);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}


}
