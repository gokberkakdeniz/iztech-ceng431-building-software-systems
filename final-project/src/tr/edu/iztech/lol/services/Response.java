package tr.edu.iztech.lol.services;

public class Response<T, E extends Exception> implements IResponse<T, E> {
	private final boolean ok;
	private final T result;
	private final E throwable;
	
	public Response(T result) {
		this.throwable = null;
		this.ok = true;
		this.result = result;
	}
	
	public Response(E throwable) {
		this.throwable = throwable;
		this.ok = false;
		this.result = null;
	}
	
	@Override
	public boolean isOK() {
		return ok;
	}

	@Override
	public T getResult() {
		return result;
	}

	@Override
	public E getException() {
		return throwable;
	}

}
