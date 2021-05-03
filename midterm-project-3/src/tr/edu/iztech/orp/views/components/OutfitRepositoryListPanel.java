package tr.edu.iztech.orp.views.components;

import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;
import tr.edu.iztech.orp.models.AbstractOutfitContainer;
import tr.edu.iztech.orp.models.OutfitRepository;

/**
 * Shows all outfits in list.
 * 
 * Behavior:
 * - updated when outfit added/removed.
 */
public class OutfitRepositoryListPanel extends OutfitListPanel<OutfitRepository, OutfitRepositoryEvent> {
	private static final long serialVersionUID = -9135208168535913299L;

	public OutfitRepositoryListPanel(AbstractOutfitContainer<OutfitRepository, OutfitRepositoryEvent> model) {
		super(model);
	}

	public void update(OutfitRepositoryEvent event) {
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
