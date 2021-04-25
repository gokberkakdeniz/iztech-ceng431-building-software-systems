package tr.edu.iztech.orp.models;

import tr.edu.iztech.orp.enums.OutfitType;

import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.orp.enums.OutfitColor;
import tr.edu.iztech.orp.enums.OutfitGender;
import tr.edu.iztech.orp.enums.OutfitSize;

public class Outfit {
	private final int id;
	private final String name;
	private final String brandName;
	private final OutfitGender gender;
	private final OutfitType type;
	private final OutfitColor color;
	private final OutfitSize[] sizes;
	private final List<Comment> comments;
	private final List<User> likedUsers;
	private final List<User> dislikedUsers;
	
	public Outfit(int id, String name, String brandName, OutfitGender gender, OutfitType type, OutfitColor color, OutfitSize[] sizes) {
		this.id = id;
		this.name = name;
		this.brandName = brandName;
		this.gender = gender;
		this.type = type;
		this.color = color;
		this.sizes = sizes.clone();
		this.comments = new ArrayList<>();
		this.likedUsers = new ArrayList<>();
		this.dislikedUsers = new ArrayList<>();
	}
	
	int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public OutfitGender getGender() {
		return gender;
	}
	
	public OutfitType getType() {
		return type;
	}
	
	public OutfitColor getColor() {
		return color;
	}
	
	public OutfitSize[] getSizes() {
		return sizes.clone();
	}
	
	public List<Comment> getComments() {
		return new ArrayList<>(comments);
	}
	
	public int getLikeCount() {
		return likedUsers.size();
	}
	
	public int getDislikeCount() {
		return dislikedUsers.size();
	}
	
	public boolean addComment(Comment comment) {
		return comments.add(comment);
	}
	
	public boolean removeComment(Comment comment) {
		return comments.remove(comment);
	}
	
	public boolean addDislike(User user) {
		return dislikedUsers.add(user);
	}
	
	public boolean removeDislike(User user) {
		return dislikedUsers.remove(user);
	}
	
	public boolean addLike(User user) {
		return likedUsers.add(user);
	}
	
	public boolean removeLike(User user) {
		return likedUsers.remove(user);
	}
}
