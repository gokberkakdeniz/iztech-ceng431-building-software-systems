package tr.edu.iztech.orp.data;

import tr.edu.iztech.orp.utils.IEvent;
import tr.edu.iztech.orp.utils.IObserver;

public interface IMonitor<T, K extends IEvent<T>> extends IObserver<T, K>  {
	T get();
}
