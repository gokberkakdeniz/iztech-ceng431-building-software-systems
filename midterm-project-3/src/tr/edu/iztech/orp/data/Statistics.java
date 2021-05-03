package tr.edu.iztech.orp.data;

import tr.edu.iztech.orp.data.monitor.MostDislikedOutfitMonitor;
import tr.edu.iztech.orp.data.monitor.MostFollowedUserMonitor;
import tr.edu.iztech.orp.data.monitor.MostLikedOutfitMonitor;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.User;

public class Statistics implements IStatistics {
	private MostLikedOutfitMonitor mostLikedOutfitMonitor;
	private MostDislikedOutfitMonitor mostDislikedOutfitMonitor;
	private MostFollowedUserMonitor mostFollowedUserMonitor;
	
	public Statistics(IRepository<User> usersRepo, IRepository<Outfit> outfitsRepo) {
		mostLikedOutfitMonitor = new MostLikedOutfitMonitor(outfitsRepo);
		mostDislikedOutfitMonitor = new MostDislikedOutfitMonitor(outfitsRepo);
		mostFollowedUserMonitor = new MostFollowedUserMonitor(usersRepo);
	}
	
	@Override
	public Outfit getMostLikedOutfit() {
		return mostLikedOutfitMonitor.get();
	}

	@Override
	public Outfit getMostDislikedOutfit() {
		return mostDislikedOutfitMonitor.get();
	}

	@Override
	public User getMostFollowedUser() {
		return mostFollowedUserMonitor.get();
	}
}
