package tr.edu.iztech.orp.utils;

public interface IObservable<T, K extends IEvent<T>> {
	void subscribe(K event, IObserver<T, K> subscriber);
	void unsubscribe(K event, IObserver<T, K> subscriber);
	void notifySubscribers(K event);
	void notifySubscribers();
}
