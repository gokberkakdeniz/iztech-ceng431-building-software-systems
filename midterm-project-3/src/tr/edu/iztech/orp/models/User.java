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
		return followedUsers.remove(user);
	}
	
	public boolean followedBy(User user) {
		return followerUsers.add(user);
	}
	
	public boolean unfollowedBy(User user) {
		return followerUsers.remove(user);
	}
	
	public boolean addCollection(OutfitCollection collection) {
		return collections.add(collection);
	}
	
	public boolean removeCollection(OutfitCollection collection) {
		return collections.remove(collection);
	}

}
