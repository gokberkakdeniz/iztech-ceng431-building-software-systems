package tr.edu.iztech.lol.exception;

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
