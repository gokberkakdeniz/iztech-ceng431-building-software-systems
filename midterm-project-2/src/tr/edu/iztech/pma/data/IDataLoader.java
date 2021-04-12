package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.IPerson;

import java.util.List;

/**
 * Loads persisted data
 */
public interface IDataLoader {
    List<IPerson> load();
}
