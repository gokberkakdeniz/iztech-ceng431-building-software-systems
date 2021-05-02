package tr.edu.iztech.orp.models;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface IRepository<T> {
	Optional<T> get(Object id);
	Optional<T> get(Predicate<T> predicate);
	
	List<T> getAll();
	List<T> getAll(Predicate<T> predicate);
}
