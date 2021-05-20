package tr.edu.iztech.lol.data;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import tr.edu.iztech.lol.model.IModel;

/**
 * Generic repository
 *
 * @param <T> model
 */
public interface IRepository<T extends IModel> {
	/**
	 * Get model by id
	 * 
	 * @param id model id
	 * @return model
	 */
	Optional<T> get(Object id);
	
	/**
	 * Get model by predicate
	 * 
	 * @param predicate search criteria
	 * @return model
	 */
	Optional<T> get(Predicate<T> predicate);
	
	/**
	 * Get all models
	 * 
	 * @return models
	 */
	List<T> getAll();
	
	/**
	 * Get models by predicate
	 * 
	 * @param predicate search criteria
	 * @return models
	 */
	List<T> getAll(Predicate<T> predicate);
	
	/**
	 * Adds new model
	 * 
	 * @param model a model to be added
	 * @return success or failure situation
	 */
	boolean add(T model);
	
	
	/**
	 * Save data
	 */
	void save();
}