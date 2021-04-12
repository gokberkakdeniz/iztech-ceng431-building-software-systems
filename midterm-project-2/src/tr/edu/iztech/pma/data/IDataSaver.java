package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.IPerson;

import java.util.List;

/**
 * Persists data
 */
public interface IDataSaver {
    void save(List<IPerson> personList);
}
