package tr.edu.iztech.orp.utils;

public interface IObserver<T, K extends IEvent<T>> {
	void update(K event);
}
