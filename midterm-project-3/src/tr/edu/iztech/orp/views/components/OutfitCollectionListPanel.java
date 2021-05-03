package tr.edu.iztech.orp.views.components;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.models.AbstractOutfitContainer;
import tr.edu.iztech.orp.models.OutfitCollection;

/**
 * Shows all outfits of collection in list.
 * 
 * Behavior:
 * - updated when outfit added/removed.
 */
public class OutfitCollectionListPanel extends OutfitListPanel<OutfitCollection, OutfitCollectionEvent> {
	private static final long serialVersionUID = -9135208168535913299L;

	public OutfitCollectionListPanel(AbstractOutfitContainer<OutfitCollection, OutfitCollectionEvent> model) {
		super(model);
	}

	public void update(OutfitCollectionEvent event) {
		switch(event) {
			case ADD_OUTFIT:
			case REMOVE_OUTFIT:
				outfits.removeAll();
				outfits.setListData(model.getAll().toArray());
			default:
				break;
		}
	}
}
