package tr.edu.iztech.pma.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import tr.edu.iztech.pma.data.json.ISerializationRepository;
import tr.edu.iztech.pma.data.json.PersonDeserializer;
import tr.edu.iztech.pma.data.json.ProductDeserializer;
import tr.edu.iztech.pma.data.json.ProductSerializationRepository;
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

/**
 * Loads data from 'data.json' file
 */
public class DataLoader implements IDataLoader {
    private final Gson gson;
    private final Path path;

    public DataLoader(Path path) {
        ISerializationRepository<Integer, IProduct> productRepo = new ProductSerializationRepository();

        this.path = path;
        gson = new GsonBuilder()
                .registerTypeAdapter(IProduct.class, new ProductDeserializer(productRepo))
                .registerTypeAdapter(IPerson.class, new PersonDeserializer(productRepo))
                .create();
    }

    @Override
    public List<IPerson> load() {
        try {
            String serialized = Files.readString(path);
            List<IPerson> deserialized = gson.fromJson(serialized, new TypeToken<List<IPerson>>(){}.getType());
            fillNullFields(deserialized);
            return deserialized;
        } catch (Exception exception) {
            throw new LoadFailedException(exception);
        }
    }

    /**
     * Normalizes deserialized data
     *
     * @param list deserialized data
     */
    private void fillNullFields(List<IPerson> list) {
        for (IPerson person: list) {
            if (person instanceof Manager) {
                fillParentsOfProducts((Product) ((Manager) person).getProduct());
            }
        }
    }

    /**
     * Updates all null 'parent' fields of product tree
     *
     * @param root root of product tree
     */
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

    /**
     * Sets parents private field 'parent' using reflection
     *
     * @param src source object whose parent will be changed
     * @param parent a value
     */
    private void setParentOf(IProduct src, IProduct parent) {
        try {
            Field parentField = AbstractProduct.class.getDeclaredField("parent");
            parentField.setAccessible(true);
            parentField.set(src, parent);
        } catch (Exception exception) {
            throw new LoadFailedException(exception);
        }
    }
}
