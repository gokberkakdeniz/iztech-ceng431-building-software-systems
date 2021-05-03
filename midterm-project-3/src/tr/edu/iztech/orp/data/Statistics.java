package tr.edu.iztech.orp.data;

import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.User;

public class Statistics implements IStatistics {
	private MostLikedOutfitMonitor mostLikedOutfitMonitor;
	
	
	public Statistics(IRepository<User> usersRepo, IRepository<Outfit> outfitsRepo) {
		mostLikedOutfitMonitor = new MostLikedOutfitMonitor(outfitsRepo);
	}
	
	@Override
	public Outfit getMostLikedOutfit() {
		return mostLikedOutfitMonitor.get();
	}

	@Override
	public Outfit getMostDislikedOutfit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getMostFollowedUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
