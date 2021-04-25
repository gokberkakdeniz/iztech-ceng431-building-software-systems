package tr.edu.iztech.orp.data;

import java.util.function.Predicate;

public interface IRepository<T, K> {
	T get(K id);
	T get(Predicate<T> predicate);
	
	T getAll();
	T getAll(Predicate<T> predicate);
}
