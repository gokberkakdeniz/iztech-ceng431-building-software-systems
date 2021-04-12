package tr.edu.iztech.pma.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tr.edu.iztech.pma.people.IPerson;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

/**
 * Saves data to 'data.json' file
 */
public class DataSaver implements IDataSaver {
    private final Path path;

    public DataSaver(Path path) {
        this.path = path;
    }

    @Override
    public void save(List<IPerson> personList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        String serialized = gson.toJson(personList);

        try {
            FileWriter writer = new FileWriter(String.valueOf(path));
            writer.write(serialized);
            writer.close();
        } catch (Exception exception) {
            throw new SaveFailedException(exception);
        }
    }
}
