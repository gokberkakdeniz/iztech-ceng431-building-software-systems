package tr.edu.iztech.lol.exception;

/**
 * Exception whose all constructors are private. 
 * This class will be used in IResponse when no 
 * exception will be throw.
 */
public final class NeverOccuredException extends Exception {
	private static final long serialVersionUID = -1792127247947246767L;
	
	private NeverOccuredException() {
		super();
	}
	
	private NeverOccuredException(String message) {
		super(message);
	}
	
	private NeverOccuredException(Throwable throwable) {
		super(throwable);
	}
	
	private NeverOccuredException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
