package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.exception.IServiceException;

public interface IResponse<T, E extends IServiceException> {
	boolean isOK();
	T getResult();
	E getException();
}
