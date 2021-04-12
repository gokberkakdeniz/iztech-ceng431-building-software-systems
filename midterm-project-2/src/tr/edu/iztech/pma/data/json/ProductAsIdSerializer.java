package tr.edu.iztech.pma.data.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import tr.edu.iztech.pma.product.IProduct;

import java.lang.reflect.Type;

/**
 * Gson library extension for serialize IPerson using its id
 *
 * This extension is used to keep object references (not creating
 * again same object)
 */
public class ProductAsIdSerializer implements JsonSerializer<IProduct> {
    @Override
    public JsonElement serialize(IProduct product, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(product.getId());
    }
}