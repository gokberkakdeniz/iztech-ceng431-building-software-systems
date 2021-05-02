package tr.edu.iztech.orp.views;

import javax.swing.JPanel;

import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.*;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

public class CollectionsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JTextField collectionNameField;
	private CollectionListPanel collectionsList;
	private OutfitListPanel outfitList;
	private JButton createCollectionButton;
	private JButton removeItemButton;

	public CollectionsPanel(User model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        collectionsList = new CollectionListPanel(model);
        collectionsList.setBounds(20, 20, 420, 540);
        add(collectionsList);
		
        collectionNameField = new JTextField();
        collectionNameField.setBounds(20, 570, 300, 30);
        collectionNameField.setColumns(10);
        add(collectionNameField);
		
        createCollectionButton = new JButton("Create");
        createCollectionButton.setBounds(215, 610, 105, 25);
        add(createCollectionButton);
              
        removeItemButton = new JButton("Remove Item From Collection");
        removeItemButton.setBounds(560, 580, 300, 30);
        add(removeItemButton);
	}
	
	public CollectionListPanel getCollectionListPanel() {
		return collectionsList;
	}

	public OutfitListPanel getOutfitListPanel() {
		return outfitList;
	}
	
	public String getNewOutfitCollectionName() {
		return collectionNameField.getText();
	}

	public void setOutfitListPanel(OutfitListPanel outfitDetail) {
		if (this.outfitList != null) remove(this.outfitList);

		if (outfitDetail != null){
			this.outfitList = outfitDetail;
			this.outfitList.setBounds(560, 20, 300, 540);
	        add(this.outfitList);
		}
		
		repaint();
		revalidate();
	}
	
	public void setVisibilityOfRemoveButton(boolean visible) {
		removeItemButton.setVisible(visible);
	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
		collectionsList.addListSelectionListener(collectionChangeListener);
	}
	
	public void addCreateButtonListener(ActionListener createButtonListener) {
		createCollectionButton.addActionListener(createButtonListener);
	}
	
	public void addRemoveItemButtonListener(ActionListener removeItemButtonListener) {
		removeItemButton.addActionListener(removeItemButtonListener);
	}
}
