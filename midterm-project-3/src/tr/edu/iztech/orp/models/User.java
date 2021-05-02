package tr.edu.iztech.orp.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.utils.AbstractObservable;


public class User extends AbstractObservable<User, UserEvent> {
	private String username;
	private String password;
	private Set<User> followedUsers;
	private Set<User> followerUsers;
	private SortedSet<OutfitCollection> collections;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.followedUsers = new HashSet<>();
		this.followerUsers = new HashSet<>();
		this.collections = new TreeSet<>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public List<OutfitCollection> getCollections() {
		return new ArrayList<>(collections);
	}
	
	public List<User> getFollowedUsers() {
		return new ArrayList<>(followedUsers);
	}
	
	public List<User> getFollowerUsers() {
		return new ArrayList<>(followerUsers);
	}
	
	public boolean follow(User user) {
		boolean result = followedUsers.add(user);
		if (result) notifySubscribers(UserEvent.FOLLOW);
		return result;
	}
	
	public boolean unfollow(User user) {
		boolean result = followedUsers.remove(user);
		if (result) notifySubscribers(UserEvent.UNFOLLOW);
		return result;
	}
	
	public boolean followedBy(User user) {
		boolean result = followerUsers.add(user);
		if (result) notifySubscribers(UserEvent.FOLLOWED);
		return result;
	}
	
	public boolean unfollowedBy(User user) {
		boolean result = followerUsers.remove(user);
		if (result) notifySubscribers(UserEvent.UNFOLLOWED);
		return result;
	}
	
	public boolean addCollection(OutfitCollection collection) {
		boolean result = collections.add(collection);
		if (result) notifySubscribers(UserEvent.ADD_COLLECTION);
		return result;
	}
	
	public boolean removeCollection(OutfitCollection collection) {
		boolean result = collections.remove(collection);
		if (result) notifySubscribers(UserEvent.REMOVE_COLLECTION);
		return result;
	}

	@Override
	public String toString() {
		return username;
	}
	
	public Node serialize(Document document) {
		Element result = document.createElement("user");
		
		Node usernameField = document.createElement("username");
		usernameField.appendChild(document.createTextNode(username));
		
		result.appendChild(usernameField);

		return result;
	}
}
