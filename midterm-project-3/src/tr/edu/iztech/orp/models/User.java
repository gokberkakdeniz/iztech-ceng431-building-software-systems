package tr.edu.iztech.orp.models;

import java.util.HashSet;
import java.util.Set;

import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.utils.AbstractObservable;

public class User extends AbstractObservable<User, UserEvent> {
	private String username;
	private String password;
	private Set<User> followedUsers;
	private Set<User> followerUsers;
	private Set<OutfitCollection> collections;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.followedUsers = new HashSet<>();
		this.followerUsers = new HashSet<>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public boolean follow(User user) {
		boolean result = followedUsers.add(user);
		notifySubscribers(UserEvent.FOLLOW);
		return result;
	}
	
	public boolean unfollow(User user) {
		boolean result = followedUsers.remove(user);
		notifySubscribers(UserEvent.UNFOLLOW);
		return result;
	}
	
	public boolean followedBy(User user) {
		boolean result = followerUsers.add(user);
		notifySubscribers(UserEvent.FOLLOWED);
		return result;
	}
	
	public boolean unfollowedBy(User user) {
		boolean result = followerUsers.remove(user);
		notifySubscribers(UserEvent.UNFOLLOWED);
		return result;
	}
	
	public boolean addCollection(OutfitCollection collection) {
		boolean result = collections.add(collection);
		notifySubscribers(UserEvent.ADD_COLLECTION);
		return result;
	}
	
	public boolean removeCollection(OutfitCollection collection) {
		boolean result = collections.remove(collection);
		notifySubscribers(UserEvent.REMOVE_COLLECTION);
		return result;
	}

}
