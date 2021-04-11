package tr.edu.iztech.pma.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tr.edu.iztech.pma.people.IPerson;

import java.io.FileWriter;
import java.util.List;

public class DataSaver implements IDataSaver {
    @Override
    public void save(List<IPerson> personList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        String serialized = gson.toJson(personList);

        try {
            FileWriter writer = new FileWriter("./data.json");
            writer.write(serialized);
            writer.close();
        } catch (Exception exception) {
            throw new SaveFailedException(exception.getMessage());
        }
    }
}
