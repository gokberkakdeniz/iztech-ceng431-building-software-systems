package tr.edu.iztech.lol.data;

import java.util.List;

/**
 * Loads data from storage
 * 
 * @param <T> model
 */
public interface IDataLoader<T> {
	/**
	 * Loads data
	 * 
	 * @return loaded data
	 */
	List<T> load();
}