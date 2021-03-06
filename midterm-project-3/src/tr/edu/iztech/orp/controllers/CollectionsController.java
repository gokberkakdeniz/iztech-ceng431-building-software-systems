package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.OutfitCollectionListPanel;
import tr.edu.iztech.orp.views.screens.CollectionsPanel;
import tr.edu.iztech.orp.utils.StringUtils;

public class CollectionsController implements IController {
	private CollectionsPanel view;
	private User model;
	private CollectionListController collectionListController;
	private OutfitCollectionListPanel outfitListPanel;
	private OutfitCollection selectedCollection;
	
	public CollectionsController(CollectionsPanel view, User model) {
		this.model = model;
		this.view = view;
		
		this.collectionListController = new CollectionListController(view.getCollectionListPanel(), model);
		
		this.view.addListSelectionListener(collectionChangeListener);
		this.view.addRemoveItemButtonListener(removeItemButtonListener);

		view.addCreateButtonListener(createButtonListener);
	}
	
	private ActionListener createButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = view.getNewOutfitCollectionName();
			if (StringUtils.isValid(name)) model.addCollection(new OutfitCollection(name));
		}
	};
	
	private ActionListener removeItemButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Outfit selected = outfitListPanel.getSelection();
			if (selected != null) {
				selectedCollection.remove(selected);
			}
		}
	};
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (selectedCollection != null) {
        			selectedCollection.unsubscribe(OutfitCollectionEvent.ADD_OUTFIT, outfitListPanel);
        			selectedCollection.unsubscribe(OutfitCollectionEvent.REMOVE_OUTFIT, outfitListPanel);	
    			}

				OutfitCollection model = ((JList<OutfitCollection>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				outfitListPanel = new OutfitCollectionListPanel(model);
    				
    				model.subscribe(OutfitCollectionEvent.ADD_OUTFIT, outfitListPanel);
    				model.subscribe(OutfitCollectionEvent.REMOVE_OUTFIT, outfitListPanel);

    				view.setOutfitListPanel(outfitListPanel);
    				view.setVisibilityOfRemoveButton(true);
    			} else {
    				view.setOutfitListPanel(null);
    				view.setVisibilityOfRemoveButton(false);
    			}
				
				selectedCollection = model;
			}
    	}
    };

	@Override
	public void destroy() {
		collectionListController.destroy();
	}
}
