package tr.edu.iztech.teamstech.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileDatabase<T> {
    List<T> load(File file) throws IOException;
    void save(File file, List<T> values);
}
