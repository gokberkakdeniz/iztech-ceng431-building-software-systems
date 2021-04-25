package tr.edu.iztech.orp.data;

import java.util.List;

public interface IDataSaver<T> {
	void save(List<T> data);
}
