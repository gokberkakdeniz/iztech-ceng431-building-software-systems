package tr.edu.iztech.orp.controllers;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.views.HomePanel;
import tr.edu.iztech.orp.views.components.OutfitDetailPanel;

public class HomeController implements IController {
	private final HomePanel view;
	private final OutfitRepository model;
	private OutfitDetailController outfitDetailController;
	
	public HomeController(HomePanel view, OutfitRepository model) {
		this.model = model;
		this.view = view;
		
		this.view.addListSelectionListener(collectionChangeListener);
	}
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
    	@SuppressWarnings("unchecked")
		public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (outfitDetailController != null) outfitDetailController.destroy();
    			
    			JList<Outfit> source = (JList<Outfit>)event.getSource();
    			Outfit model = source.getSelectedValue();
    			
    			if (model != null) {
        			OutfitDetailPanel outfitDetail = new OutfitDetailPanel(view, model);
        			outfitDetailController = new OutfitDetailController(outfitDetail, model);
        			view.setOutfitDetailPanel(outfitDetail);
    			} else {
        			view.setOutfitDetailPanel(null);
    			}
    		}
    	}
    };
	
	@Override
	public void destroy() {
		if (outfitDetailController != null) outfitDetailController.destroy();
		model.unsubscribe(OutfitRepositoryEvent.ADD_OUTFIT, view);
	}

}
