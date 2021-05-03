package tr.edu.iztech.orp.data;

import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.User;

public interface IStatistics {
	Outfit getMostLikedOutfit();
	Outfit getMostDislikedOutfit();
	User getMostFollowedUser();
}
