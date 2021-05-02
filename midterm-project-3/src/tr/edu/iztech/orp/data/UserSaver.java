package tr.edu.iztech.orp.data;

import java.io.File;
import java.util.List;

import tr.edu.iztech.orp.models.User;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class UserSaver implements IDataSaver<User> {
	private final DocumentBuilderFactory factory;
	private final DocumentBuilder builder;
    private final Document doc; 
    private File file;
    
	public UserSaver(String pathname) throws ParserConfigurationException {
		super();
		this.file = new File(pathname);
		factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
	}
	
	@Override
	public void save(List<User> data) {
		Element root = doc.createElementNS("iztech:group6", "users");
        doc.appendChild(root);
        
        for(User user: data) {
            root.appendChild(user.serialize(doc));
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			e1.printStackTrace();
		}
        
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        DOMSource source = new DOMSource(doc);
        
        StreamResult myFile = new StreamResult(file);

        try {
	        transformer.transform(source, myFile);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}


}
