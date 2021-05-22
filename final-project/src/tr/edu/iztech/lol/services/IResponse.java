package tr.edu.iztech.lol.services;

public interface IResponse<T, E extends Exception> {
	boolean isOK();
	T getResult();
	E getException();
}
