package tr.edu.iztech.pma.data.json;

import com.google.gson.*;
import tr.edu.iztech.pma.product.IProduct;
import tr.edu.iztech.pma.product.state.IProductState;

import java.lang.reflect.Type;

/**
 * Gson library extension for deserialize IPerson (Admin, Manager, Employee)
 */
public class ProductDeserializer implements JsonDeserializer<IProduct> {
    private final String typeElementName;
    private final Gson gson;
    private final ISerializationRepository<Integer,IProduct> productRepo;

    /**
     * JsonDeserializer for IProduct
     *
     * @param typeElementName concrete class name field
     * @param productRepo  where the deserialized products will be stored
     */
    public ProductDeserializer(String typeElementName, ISerializationRepository<Integer, IProduct> productRepo) {
        this.typeElementName = typeElementName;
        this.productRepo = productRepo;
        this.gson = new GsonBuilder()
                // To be able to deserialize Product and Assembly we need this deserializer again
                // because the field 'children' is also type of IProcuct.
                .registerTypeAdapter(IProduct.class, this)
                // Also we need custom deserializer for IProductState.
                .registerTypeAdapter(IProductState.class, new ProductStateDeserializer())
                .create();
    }

    /**
     * JsonDeserializer for IProduct
     *
     * @param productRepo  where the deserialized products will be stored
     */
    public ProductDeserializer(ISerializationRepository<Integer,IProduct> productRepo) {
        this("type", productRepo);
    }

    @Override
    public IProduct deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String className = object.get(typeElementName).getAsString(); // get concrete class name

        try {
            // deserialize using type token
            IProduct result =  gson.fromJson(jsonElement, (Type) Class.forName("tr.edu.iztech.pma.product." + className));
            // add result to repository
            productRepo.add(result);

            return result;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
