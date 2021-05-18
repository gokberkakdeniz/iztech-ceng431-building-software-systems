package tr.edu.iztech.lol.data;

import java.util.List;

/**
 * Saves data to any storage
 *
 * @param <T> model
 */
public interface IDataSaver<T> {
	/**
	 * Saves data
	 * 
	 * @param data
	 */
	void save(List<T> data);
}