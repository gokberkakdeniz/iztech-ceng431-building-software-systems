package tr.edu.iztech.pma.data.json;

import com.google.gson.*;
import tr.edu.iztech.pma.product.IProduct;
import tr.edu.iztech.pma.product.state.IProductState;

import java.lang.reflect.Type;


public class ProductDeserializer implements JsonDeserializer<IProduct> {
    private final String typeElementName;
    private final Gson gson;
    private final ISerializationRepository<Integer,IProduct> productRepo;

    public ProductDeserializer(String typeElementName, ISerializationRepository<Integer, IProduct> productRepo) {
        this.typeElementName = typeElementName;
        this.productRepo = productRepo;
        this.gson = new GsonBuilder()
                // to be able to deserialize Product and Assembly we need this deserializer again
                // because the field 'children' is also type of IProcuct.
                .registerTypeAdapter(IProduct.class, this)
                .registerTypeAdapter(IProductState.class, new ProductStateDeserializer())
                .create();
    }

    public ProductDeserializer(ISerializationRepository<Integer,IProduct> productRepo) {
        this("type", productRepo);
    }

    @Override
    public IProduct deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String className = object.get(typeElementName).getAsString();
        object.remove("parentId");

        try {
            IProduct result =  gson.fromJson(jsonElement, (Type) Class.forName("tr.edu.iztech.pma.product." + className));
            productRepo.add(result);
            return result;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
