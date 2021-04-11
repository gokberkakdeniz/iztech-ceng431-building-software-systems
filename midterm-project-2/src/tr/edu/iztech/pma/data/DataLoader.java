package tr.edu.iztech.pma.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import tr.edu.iztech.pma.data.json.*;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.product.IProduct;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataLoader implements IDataLoader {
    @Override
    public List<IPerson> load() {
        ISerializationRepository<Integer, IProduct> productRepo = new ProductSerializationRepository();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(IProduct.class, new ProductDeserializer(productRepo))
                .registerTypeAdapter(IPerson.class, new PersonDeserializer(productRepo))
                .create();

        try {
            String serialized = Files.readString(Path.of("./data.json"));
            return  gson.fromJson(serialized, new TypeToken<List<IPerson>>(){}.getType());
        } catch (Exception exception) {
            throw new LoadFailedException(exception);
        }

    }
}
