package tr.edu.iztech.orp.models;

public class Comment {
	private String authorId;
	private String text;
	
	public Comment(User author, String text) {
		this.authorId = author.getUsername();
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public String getAuthor() {
		return authorId;
	}
}
