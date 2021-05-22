package tr.edu.iztech.lol.utils;

public interface IObservable<T> {
	void subscribe(IObserver<T> subscriber);

	void unsubscribe(IObserver<T> subscriber);
	
	void notifySubscribers();
}