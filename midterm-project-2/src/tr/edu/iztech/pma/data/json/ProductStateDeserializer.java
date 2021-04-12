package tr.edu.iztech.pma.data.json;

import com.google.gson.*;
import tr.edu.iztech.pma.product.state.IProductState;

import java.lang.reflect.Type;

/**
 * Gson library extension for deserialize IProductState
 */
public class ProductStateDeserializer implements JsonDeserializer<IProductState> {
    private final String typeElementName;
    private final Gson gson;

    public ProductStateDeserializer(String typeElementName) {
        this.typeElementName = typeElementName;
        this.gson = new Gson();
    }

    public ProductStateDeserializer() {
        this("type");
    }

    @Override
    public IProductState deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String className = object.get(typeElementName).getAsString(); // get concrete class name

        try {
            // deserialize using type token
            return gson.fromJson(jsonElement, (Type) Class.forName("tr.edu.iztech.pma.product.state." + className));
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
