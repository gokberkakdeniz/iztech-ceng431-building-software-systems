package tr.edu.iztech.teamstech.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CsvIO<T> implements FileIO<T> {
    private final BufferedReader reader;
    private final Class<T> dataClass;

    public CsvIO(File file, Class<T> dataClass) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file));
        this.dataClass = dataClass;
    }

    public CsvIO(String file, Class<T> dataClass) throws FileNotFoundException {
        this(new File(file), dataClass);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T read(int lineNumber) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String line = reader.lines().skip(lineNumber).findFirst().orElseThrow();
        String[] args = line.split(",");

        Constructor<?> constructor = dataClass.getConstructors()[0];
        List<Object> typedArgs = new ArrayList<>(constructor.getParameterCount());

        Iterator<String> argsIter = Arrays.stream(args).iterator();
        Iterator<Class<?>> typesIter = Arrays.stream(constructor.getParameterTypes()).iterator();

        while (typesIter.hasNext() && argsIter.hasNext()) {
            Class<?> type = typesIter.next();
            String arg = argsIter.next();

            if (type == String.class) {
                typedArgs.add(arg);
            } else if (arg.equals("")) {
                if (type == Integer.class) {
                    typedArgs.add(0);
                } else if (type == Boolean.class) {
                    typedArgs.add(true);
                } else {
                    typedArgs.add(null);
                }
            } else {
                typedArgs.add(type.getMethod("valueOf", String.class).invoke(null, arg));
            }
        }

        return (T) constructor.newInstance(typedArgs.toArray());
    }

    @Override
    public List<T> readAll() {
        return null;
    }
}
