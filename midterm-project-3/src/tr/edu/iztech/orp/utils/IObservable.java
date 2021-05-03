package tr.edu.iztech.orp.utils;

/**
 * A class which notifies its subscribers when its data changed
 *
 * @param <T> a class to be observed
 * @param <K> event type
 */
public interface IObservable<T, K extends IEvent<T>> {
	/**
	 * Subscribe to event
	 * 
	 * @param event
	 * @param subscriber
	 */
	void subscribe(K event, IObserver<T, K> subscriber);
	
	/**
	 * Subscribe from event
	 * 
	 * @param event
	 * @param subscriber
	 */
	void unsubscribe(K event, IObserver<T, K> subscriber);
	
	/**
	 * Notify subscribers of event
	 * 
	 * @param event occurred event 
	 */
	void notifySubscribers(K event);
	
	/**
	 * Notify all subscribers
	 */
	void notifySubscribers();
}
