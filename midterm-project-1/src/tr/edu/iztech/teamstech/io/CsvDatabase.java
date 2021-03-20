package tr.edu.iztech.teamstech.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CsvDatabase<T> implements FileDatabase<T> {
    private final Class<T> dataClass;

    public CsvDatabase(Class<T> dataClass) {
        this.dataClass = dataClass;
    }

    @SuppressWarnings("unchecked")
    public T deserialize(String line) {
        try {
            String[] args = line.split(",", -1);

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
        } catch (Exception e) {
            throw new Error("The file is malformed!");
        }
    }

    @Override
    public List<T> load(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<T> result = reader.lines().skip(1).map(this::deserialize).collect(Collectors.toList());

        reader.close();

        return result;
    }

    @Override
    public void save(File file, List<T> values) {

    }


}
