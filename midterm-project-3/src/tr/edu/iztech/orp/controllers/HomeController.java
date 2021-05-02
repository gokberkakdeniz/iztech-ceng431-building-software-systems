package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.app.Session;
import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.views.HomePanel;
import tr.edu.iztech.orp.views.components.OutfitDetailPanel;

public class HomeController implements IController {
	private final HomePanel view;
	private final OutfitRepository model;
	
	public HomeController(HomePanel view, OutfitRepository model) {
		this.model = model;
		this.view = view;
		
		this.view.addListSelectionListener(collectionChangeListener);
	}
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
    	@SuppressWarnings("unchecked")
		public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			Outfit model = ((JList<Outfit>)event.getSource()).getSelectedValue();

    			OutfitDetailPanel outfitDetail = new OutfitDetailPanel(view, model);
    			new OutfitDetailController(outfitDetail, model);
    			view.setOutfitDetailPanel(outfitDetail);
    		}
    	}
    };
	
	@Override
	public void destroy() {
		model.unsubscribe(OutfitRepositoryEvent.ADD_OUTFIT, view);
	}

}
