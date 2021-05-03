package tr.edu.iztech.orp.data.monitor;

import java.util.List;

import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;

/**
 * Monitors all outfits to find most liked outfit
 */
public class MostLikedOutfitMonitor implements IMonitor<Outfit, OutfitEvent> {
	private Outfit mostLiked;
	
	public MostLikedOutfitMonitor(IRepository<Outfit> outfitRepo) {
		List<Outfit> outfits = outfitRepo.getAll();
		
		outfits.forEach(o -> {
			subscribeTo(o);
			if (hasMoreLike(o)) mostLiked = o;
		});
	}

	@Override
	public void update(OutfitEvent event) {
		if (hasMoreLike(event.getSubject())) mostLiked = event.getSubject();
	}

	@Override
	public Outfit get() {
		return mostLiked;
	}

	private void subscribeTo(Outfit outfit) {
		outfit.subscribe(OutfitEvent.LIKE, this);
		outfit.subscribe(OutfitEvent.REMOVE_LIKE, this);
	}
	
	private boolean hasMoreLike(Outfit outfit) {
		return mostLiked == null || outfit.getLikeCount() > mostLiked.getLikeCount();
	}
}
