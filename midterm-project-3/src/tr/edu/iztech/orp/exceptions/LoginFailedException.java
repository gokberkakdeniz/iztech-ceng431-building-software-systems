package tr.edu.iztech.orp.exceptions;

public class LoginFailedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LoginFailedException() {
		super("The username or password is invalid.");
	}
}
