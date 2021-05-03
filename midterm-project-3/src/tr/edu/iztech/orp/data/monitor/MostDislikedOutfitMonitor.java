package tr.edu.iztech.orp.data.monitor;

import java.util.List;

import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;


/**
 * Monitors all outfits to find most disliked outfit
 */
public class MostDislikedOutfitMonitor implements IMonitor<Outfit, OutfitEvent> {
	private Outfit mostDisliked;
	
	public MostDislikedOutfitMonitor(IRepository<Outfit> outfitRepo) {
		List<Outfit> outfits = outfitRepo.getAll();
		
		outfits.forEach(o -> {
			subscribeTo(o);
			if (hasMoreDislike(o)) mostDisliked = o;
		});
	}

	@Override
	public void update(OutfitEvent event) {
		if (hasMoreDislike(event.getSubject())) mostDisliked = event.getSubject();
	}

	@Override
	public Outfit get() {
		return mostDisliked;
	}

	private void subscribeTo(Outfit outfit) {
		outfit.subscribe(OutfitEvent.DISLIKE, this);
		outfit.subscribe(OutfitEvent.REMOVE_DISLIKE, this);
	}
	
	private boolean hasMoreDislike(Outfit outfit) {
		return mostDisliked == null || outfit.getDislikeCount() > mostDisliked.getDislikeCount();
	}
}
