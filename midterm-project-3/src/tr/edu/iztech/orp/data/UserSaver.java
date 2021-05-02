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
    static Document doc; 
    File file;
    
	public UserSaver(String pathname) throws ParserConfigurationException {
		super();
		this.file = new File(pathname);
		factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(List<User> data) {
		Element root = doc.createElementNS("BLABLA", "users");
        doc.appendChild(root);
        
        for(User user: data) {
//            root.appendChild((Node) user);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = null;
		try {
			transf = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        DOMSource source = new DOMSource(doc);
        
        StreamResult console = new StreamResult(System.out);
        StreamResult myFile = new StreamResult(file);

        try {
			transf.transform(source, console);
	        transf.transform(source, myFile);

		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
