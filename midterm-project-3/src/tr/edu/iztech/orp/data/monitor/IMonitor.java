package tr.edu.iztech.orp.data.monitor;

import tr.edu.iztech.orp.utils.IEvent;
import tr.edu.iztech.orp.utils.IObserver;

/**
 * Monitors models for statistics purposes
 *
 * @param <T> model
 * @param <K> model event
 */
public interface IMonitor<T, K extends IEvent<T>> extends IObserver<T, K>  {
	/**
	 * Returns the model among subscribed models according to statistics algorithm
	 * 
	 * @return calculated data
	 */
	T get();
}
