package tr.edu.iztech.orp.utils;

/**
 * Event for observer/observable
 *
 * @param <T> observe class
 */
public interface IEvent<T> {
	/**
	 * Inject obsersables
	 * 
	 * @param subject observable
	 * @return itself
	 */
	IEvent<T> withSubject(T subject);
	
	/**
	 * Checks if has observer added as payload
	 * 
	 * @return true if has otherwise false
	 */
	boolean hasSubject();
	
	/**
	 * Return subject of event
	 * 
	 * @return observable
	 */
	T getSubject();	
}
