package tr.edu.iztech.pma.data.json;

import tr.edu.iztech.pma.product.IProduct;

import java.util.HashMap;
import java.util.Map;

/**
 * IProduct repository to fulfill Employee's product during serialization
 */
public class ProductSerializationRepository implements ISerializationRepository<Integer, IProduct> {
    private final Map<Integer, IProduct> products;

    public ProductSerializationRepository() {
        products = new HashMap<>();
    }

    public void add(IProduct product) {
        products.put(product.getId(), product);
    }

    public IProduct get(Integer id) {
        return products.get(id);
    }
}
