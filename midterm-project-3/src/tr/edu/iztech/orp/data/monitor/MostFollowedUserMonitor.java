package tr.edu.iztech.orp.data.monitor;

import java.util.List;

import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.User;

/**
 * Monitors all users to find most followed user
 */
public class MostFollowedUserMonitor implements IMonitor<User, UserEvent> {
	private User mostFollowed;
	
	public MostFollowedUserMonitor(IRepository<User> usersRepo) {
		List<User> outfits = usersRepo.getAll();
		
		outfits.forEach(o -> {
			subscribeTo(o);
			if (hasMoreFollower(o)) mostFollowed = o;
		});
	}

	@Override
	public void update(UserEvent event) {
		User user = event.getSubject();
		if (hasMoreFollower(user)) mostFollowed = user;
	}

	@Override
	public User get() {
		return mostFollowed;
	}

	private void subscribeTo(User user) {
		user.subscribe(UserEvent.UNFOLLOWED, this);
		user.subscribe(UserEvent.FOLLOWED, this);
	}
	
	private boolean hasMoreFollower(User user) {
		return mostFollowed == null || user.getFollowerCount() > mostFollowed.getFollowerCount();
	}
}
