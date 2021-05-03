package tr.edu.iztech.orp.utils;

public interface IEvent<T> {
	IEvent<T> withSubject(T subject);
	boolean hasSubject();
	T getSubject();	
}
