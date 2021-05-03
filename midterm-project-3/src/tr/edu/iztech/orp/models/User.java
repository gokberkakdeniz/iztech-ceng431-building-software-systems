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
	
	public int getFollowedCount() {
		return followedUsers.size();
	}
	
	public List<User> getFollowerUsers() {
		return new ArrayList<>(followerUsers);
	}
	
	public int getFollowerCount() {
		return followerUsers.size();
	}
	
	public boolean follow(User user) {
		boolean result = followedUsers.add(user);
		
		if (result) {
			user.followedBy(this);
			notifySubscribers(UserEvent.FOLLOW.withSubject(this));
		}
		
		return result;
	}
	
	public boolean unfollow(User user) {
		boolean result = followedUsers.remove(user);
		
		if (result) {
			user.unfollowedBy(this);
			notifySubscribers(UserEvent.UNFOLLOW.withSubject(this));
		}
		
		return result;
	}
	
	public boolean followedBy(User user) {
		boolean result = followerUsers.add(user);
		if (result) notifySubscribers(UserEvent.FOLLOWED.withSubject(this));
		return result;
	}
	
	public boolean unfollowedBy(User user) {
		boolean result = followerUsers.remove(user);
		if (result) notifySubscribers(UserEvent.UNFOLLOWED.withSubject(this));
		return result;
	}
	
	public boolean addCollection(OutfitCollection collection) {
		boolean result = collections.add(collection);
		if (result) notifySubscribers(UserEvent.ADD_COLLECTION.withSubject(this));
		return result;
	}
	
	public boolean removeCollection(OutfitCollection collection) {
		boolean result = collections.remove(collection);
		if (result) notifySubscribers(UserEvent.REMOVE_COLLECTION.withSubject(this));
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
		
		Node passwordField = document.createElement("password");
		passwordField.appendChild(document.createTextNode(password));
		
		Node followedUsersField = document.createElement("followedUsers");
		Node followedUser;
		for(User user: followedUsers) {
			followedUser = document.createElement("user");
			followedUser.appendChild(document.createTextNode(user.getUsername()));
			followedUsersField.appendChild(followedUser);
		}

		Node followerUsersField = document.createElement("followerUsers");
		Node followerUser;
		for(User user: followerUsers) {
			followerUser = document.createElement("user");
			followerUser.appendChild(document.createTextNode(user.getUsername()));
			followerUsersField.appendChild(followerUser);
		}
		
		Node collectionsField = document.createElement("collections");
		Node tempCollection, collectionName, outfits, outfitId;
		for(OutfitCollection collection: collections) {
			tempCollection = document.createElement("collection");
			collectionName = document.createElement("name");
			collectionName.appendChild(document.createTextNode(collection.getName()));
			outfits = document.createElement("outfits");
			for(Outfit outfit: collection.getAll()) {
				outfitId = document.createElement("id");
				outfitId.appendChild(document.createTextNode(String.valueOf(outfit.getId())));
				outfits.appendChild(outfitId);
			}
			tempCollection.appendChild(collectionName);
			tempCollection.appendChild(outfits);
			collectionsField.appendChild(tempCollection);
		}
		
		result.appendChild(usernameField);
		result.appendChild(passwordField);
		result.appendChild(followedUsersField);
		result.appendChild(followerUsersField);
		result.appendChild(collectionsField);

		return result;
	}
}
