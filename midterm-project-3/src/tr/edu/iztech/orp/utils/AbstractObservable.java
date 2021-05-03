package tr.edu.iztech.orp.utils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Abstract implementation of Observer pattern.
 * Supports subscription by event to improve performance.
 *
 * @param <T> observer class
 * @param <K> event class
 */
public abstract class AbstractObservable<T, K extends IEvent<T>> implements IObservable<T,K> {
	private final Set<Subscriber> subscribers = new HashSet<>();
	
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

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof AbstractObservable<?,?>.Subscriber)) return false;
			
			AbstractObservable<?,?>.Subscriber casted = (AbstractObservable<?,?>.Subscriber) o;
			return observer == casted.observer && event.equals(casted.event);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(event, observer);
		}
	}
}
