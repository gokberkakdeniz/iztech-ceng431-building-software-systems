package tr.edu.iztech.lol.model;

public class User implements IModel {
	private String username;
	
	public User(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	
}
