package tr.edu.iztech.lol.exception;

public class UserNotFoundException extends Exception implements IServiceException {
	private static final long serialVersionUID = -1274843288177049067L;

	public UserNotFoundException() {
		super("The user not found.");
	}
}
