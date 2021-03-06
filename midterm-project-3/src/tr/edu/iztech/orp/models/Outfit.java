package tr.edu.iztech.orp.models;

import tr.edu.iztech.orp.enums.OutfitType;
import tr.edu.iztech.orp.utils.AbstractObservable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tr.edu.iztech.orp.enums.OutfitColor;
import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.enums.OutfitGender;
import tr.edu.iztech.orp.enums.OutfitOccasion;
import tr.edu.iztech.orp.enums.OutfitSize;

public class Outfit extends AbstractObservable<Outfit, OutfitEvent> implements Comparable<Outfit> {
	private final int id;
	private final String name;
	private final String brandName;
	private final OutfitGender gender;
	private final OutfitType type;
	private final OutfitColor color;
	private final OutfitSize[] sizes;
	private final OutfitOccasion occasion;
	private final List<Comment> comments;
	private final Set<String> likedUserIds;
	private final Set<String> dislikedUserIds;
	
	public Outfit(int id, String name, String brandName, OutfitGender gender, OutfitType type, OutfitOccasion occasion, OutfitColor color, OutfitSize[] sizes) {
		this.id = id;
		this.name = name;
		this.brandName = brandName;
		this.gender = gender;
		this.type = type;
		this.occasion = occasion;
		this.color = color;
		this.sizes = sizes.clone();
		this.comments = new ArrayList<>();
		this.likedUserIds = new HashSet<>();
		this.dislikedUserIds = new HashSet<>();
	}
	
	public int getId() {
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
	
	public OutfitOccasion getOccasion() {
		return occasion;
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
	
	public List<String> getLikedUserIds() {
		return new ArrayList<>(likedUserIds);
	}
	
	public int getLikeCount() {
		return likedUserIds.size();
	}
	
	public List<String> getDislikedUserIds() {
		return new ArrayList<>(dislikedUserIds);
	}
	
	public int getDislikeCount() {
		return dislikedUserIds.size();
	}

	public boolean addComment(Comment comment) {
		boolean result = comments.add(comment);
		if (result) notifySubscribers(OutfitEvent.ADD_COMMENT.withSubject(this));
		return result;
	}
	
	public boolean removeComment(Comment comment) {
		boolean result = comments.remove(comment);
		if (result) notifySubscribers(OutfitEvent.REMOVE_COMMENT.withSubject(this));
		return result;
	}
	
	public boolean addDislike(String userId) {
		boolean result = likedUserIds.remove(userId);
		if (result) notifySubscribers(OutfitEvent.LIKE.withSubject(this));
		
		result = dislikedUserIds.add(userId);
		if (result) notifySubscribers(OutfitEvent.DISLIKE.withSubject(this));
		return result;
	}
	
	public boolean addDislike(User user) {
		return addDislike(user.getUsername());
	}
	
	public boolean removeDislike(User user) {
		boolean result = dislikedUserIds.remove(user.getUsername());
		if (result) notifySubscribers(OutfitEvent.REMOVE_DISLIKE.withSubject(this));
		return result;
	}
	
	public boolean addLike(String userId) {
		boolean result = dislikedUserIds.remove(userId);
		if (result) notifySubscribers(OutfitEvent.DISLIKE.withSubject(this));

		result = likedUserIds.add(userId);
		if (result) notifySubscribers(OutfitEvent.LIKE.withSubject(this));
		
		return result;
	}
	
	public boolean addLike(User user) {
		return addLike(user.getUsername());
	}
	
	public boolean removeLike(User user) {
		boolean result = likedUserIds.remove(user.getUsername());
		if (result) notifySubscribers(OutfitEvent.REMOVE_LIKE.withSubject(this));
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("<html>%s by <i>%s</i> (#%d)</html>", name, brandName, id);
	}

	@Override
	public int compareTo(Outfit o) {
		return getId() - o.getId();
	}
}
