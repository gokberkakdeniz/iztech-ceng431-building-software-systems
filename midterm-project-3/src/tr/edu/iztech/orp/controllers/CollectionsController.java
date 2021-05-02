package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.app.Session;
import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;
import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.utils.IObserver;
import tr.edu.iztech.orp.views.components.CollectionListPanel;
import tr.edu.iztech.orp.views.components.OutfitDetailPanel;
import tr.edu.iztech.orp.views.components.OutfitListPanel;
import tr.edu.iztech.orp.views.screens.CollectionsPanel;

public class CollectionsController implements IController {
	private CollectionsPanel view;
	private User model;
	private CollectionListController collectionListController;
	private OutfitListPanel<OutfitCollection, OutfitCollectionEvent> outfitListPanel;
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
			model.addCollection(new OutfitCollection(view.getNewOutfitCollectionName()));
		}
	};
	
	private ActionListener removeItemButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectedCollection.remove(outfitListPanel.getSelection());
		}
	};
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			// TODO: Make controller and implement destroy;
    			
				OutfitCollection model = ((JList<OutfitCollection>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				outfitListPanel = new OutfitListPanel<>(model);
    				
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
