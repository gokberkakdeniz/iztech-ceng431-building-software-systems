package tr.edu.iztech.orp.data.monitor;

import java.util.List;

import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.User;

public class MostFollowedUserMonitor implements IMonitor<User, UserEvent> {
	private User mostFollowed;
	
	public MostFollowedUserMonitor(IRepository<User> usersRepo) {
		List<User> outfits = usersRepo.getAll();
		
		outfits.forEach(o -> {
			subscribeTo(o);
			if (hasMoreLike(o)) mostFollowed = o;
		});
	}

	@Override
	public void update(UserEvent event) {
		if (hasMoreLike(event.getSubject())) mostFollowed = event.getSubject();
	}

	@Override
	public User get() {
		return mostFollowed;
	}

	private void subscribeTo(User user) {
		user.subscribe(UserEvent.FOLLOW, this);
		user.subscribe(UserEvent.UNFOLLOW, this);
	}
	
	private boolean hasMoreLike(User user) {
		return mostFollowed == null || user.getFollowerCount() > mostFollowed.getFollowerCount();
	}
}
