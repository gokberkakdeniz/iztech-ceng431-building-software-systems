package tr.edu.iztech.pma.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import tr.edu.iztech.pma.data.json.*;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.product.AbstractProduct;
import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.IProduct;
import tr.edu.iztech.pma.product.Product;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataLoader implements IDataLoader {
    private final ISerializationRepository<Integer, IProduct> productRepo;
    private final Gson gson;

    public DataLoader() {
        productRepo = new ProductSerializationRepository();
        gson = new GsonBuilder()
                .registerTypeAdapter(IProduct.class, new ProductDeserializer(productRepo))
                .registerTypeAdapter(IPerson.class, new PersonDeserializer(productRepo))
                .create();
    }

    @Override
    public List<IPerson> load() {
        try {
            String serialized = Files.readString(Path.of("./data.json"));
            List<IPerson> deserialized = gson.fromJson(serialized, new TypeToken<List<IPerson>>(){}.getType());
            fillNullFields(deserialized);
            return deserialized;
        } catch (Exception exception) {
            throw new LoadFailedException(exception);
        }
    }

    private void fillNullFields(List<IPerson> list) {
        for (IPerson person: list) {
            if (person instanceof Manager) {
                fillParentsOfProducts((Product) ((Manager) person).getProduct());
            }
        }
    }

    private void fillParentsOfProducts(Product root) {
        Queue<IProduct> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            IProduct current = queue.poll();

            if (current instanceof AbstractProductWithChildren) {
                List<IProduct> children = ((AbstractProductWithChildren) current).getChildren();
                children.forEach(child -> setParentOf(child, current));
                queue.addAll(((AbstractProductWithChildren) current).getChildren());
            }
        }
    }

    private void setParentOf(IProduct src, IProduct parent) {
        try {
            Field parentField = AbstractProduct.class.getDeclaredField("parent");
            parentField.setAccessible(true);
            parentField.set(src, parent);
        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
    }
}
