package tr.edu.iztech.lol.exception;

public class LoginException extends Exception {
	private static final long serialVersionUID = -1274843288177049067L;

	public LoginException() {
		super("Something happened while logging.");
	}
	
	public LoginException(String message) {
		super(message);
	}
}
