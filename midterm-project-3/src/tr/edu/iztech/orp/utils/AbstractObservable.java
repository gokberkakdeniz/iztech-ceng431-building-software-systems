package tr.edu.iztech.orp.utils;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractObservable<T, K extends IEvent<T>> implements IObservable<T,K> {
	private final List<Subscriber> subscribers = new LinkedList<>();
	
	@Override
	public void subscribe(K event, IObserver<T, K> subscriber) {
		subscribers.add(new Subscriber(subscriber, event));
	}

	@Override
	public void unsubscribe(K event, IObserver<T, K> subscriber) {
		subscribers.removeIf(s -> s.is(subscriber, event));
	}

	@Override
	public void notifySubscribers(K event) {
		subscribers.forEach(s -> s.updateIf(event));		
	}

	@Override
	public void notifySubscribers() {
		subscribers.forEach(Subscriber::update);		
	}

	private class Subscriber {
		private final IObserver<T, K> observer;
		private final K event;
		
		public Subscriber(IObserver<T, K>  observer, K event) {
			this.event = event;
			this.observer = observer;
		}
		
		public boolean is(IObserver<T, K> observer, K event) {
			return this.event == event && this.observer == observer;
		}
		
		public void update() {
			observer.update(event);
		}
		
		public void updateIf(K event) {
			if (this.event == event) observer.update(event);
		}
	}
}
