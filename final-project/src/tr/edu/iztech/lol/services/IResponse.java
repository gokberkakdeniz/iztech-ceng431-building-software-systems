package tr.edu.iztech.lol.services;

/**
 * Service response/result interface
 */
public interface IResponse<T, E extends Exception> {
	boolean isOK();
	T getResult();
	E getException();
}
