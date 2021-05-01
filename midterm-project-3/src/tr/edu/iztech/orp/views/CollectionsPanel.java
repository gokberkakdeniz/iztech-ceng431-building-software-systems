package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import tr.edu.iztech.orp.views.components.*;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CollectionsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JTextField userNameField;

	public CollectionsPanel() {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        JPanel userList = new CollectionListPanel();
        userList.setBounds(20, 20, 420, 540);
        add(userList);
		
        userNameField = new JTextField();
        userNameField.setBounds(20, 570, 300, 30);
        userNameField.setColumns(10);
        add(userNameField);
		
        JButton createUserButton = new JButton("Create");
        createUserButton.setBounds(215, 610, 105, 25);
        add(createUserButton);
        
        JPanel outfitList = new OutfitListPanel();
        outfitList.setBounds(560, 20, 300, 540);
		add(outfitList);
        
        JButton removeItemButton = new JButton("Remove Item From Collection");
        removeItemButton.setBounds(560, 580, 300, 30);
        add(removeItemButton);
        
	}
}
