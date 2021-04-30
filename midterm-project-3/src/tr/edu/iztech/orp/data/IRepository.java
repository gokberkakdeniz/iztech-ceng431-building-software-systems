package tr.edu.iztech.orp.data;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface IRepository<T, K> {
	Optional<T> get(K id);
	Optional<T> get(Predicate<T> predicate);
	
	List<T> getAll();
	List<T> getAll(Predicate<T> predicate);
}
