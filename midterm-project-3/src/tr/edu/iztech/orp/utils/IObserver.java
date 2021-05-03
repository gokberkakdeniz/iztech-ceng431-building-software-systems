package tr.edu.iztech.orp.utils;

/**
 * Observer interface
 * 
 * @param <T> observable
 * @param <K> event
 */
public interface IObserver<T, K extends IEvent<T>> {
	/**
	 * Notify handler
	 * 
	 * @param event type
	 */
	void update(K event);
}
