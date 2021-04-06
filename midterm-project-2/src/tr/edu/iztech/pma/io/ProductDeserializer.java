package tr.edu.iztech.pma.io;

import com.google.gson.*;
import tr.edu.iztech.pma.product.IProduct;

import java.lang.reflect.Type;


public class ProductDeserializer implements JsonDeserializer<IProduct> {
    private final String typeElementName;
    private final Gson gson;

    public ProductDeserializer(String typeElementName) {
        this.typeElementName = typeElementName;
        this.gson = new GsonBuilder()
                // to be able to deserialize Product and Assembly we need this deserializer again
                // because the field 'children' is also type of IProcuct.
                .registerTypeAdapter(IProduct.class, this)
                .create();
    }

    public ProductDeserializer() {
        this("type");
    }

    @Override
    public IProduct deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String className = object.get(typeElementName).getAsString();

        try {
            return gson.fromJson(jsonElement, (Type) Class.forName("tr.edu.iztech.pma.product." + className));
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
