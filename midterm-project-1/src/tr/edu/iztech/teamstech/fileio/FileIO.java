package tr.edu.iztech.teamstech.fileio;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface FileIO<T> {
    public T read(int lineNumber) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    public List<T> readAll();

//    public boolean update(int lineNumber, T line);
//
//    public boolean delete(int lineNumber);
//    public boolean delete(T line);

//    public boolean rewrite(List<T> line);
}
