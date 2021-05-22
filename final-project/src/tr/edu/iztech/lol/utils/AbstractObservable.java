package tr.edu.iztech.lol.utils;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractObservable<T> implements IObservable<T> {
	private final Set<IObserver<T>> subscribers = new HashSet<>();
	
	@Override
	public void subscribe(IObserver<T> subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void unsubscribe(IObserver<T> subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscribers() {
		subscribers.forEach(IObserver<T>::update);		
	}
}