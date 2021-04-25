package tr.edu.iztech.orp.data;

import java.util.List;

public interface IDataLoader<T> {
	List<T> load();
}
