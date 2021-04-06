package tr.edu.iztech.pma.io;

import com.google.gson.*;
import tr.edu.iztech.pma.people.IPerson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class PersonDeserializer implements JsonDeserializer<IPerson> {
    private final String typeElementName;
    private final Gson gson;

    public PersonDeserializer(String typeElementName) {
        this.typeElementName = typeElementName;
        this.gson = new Gson();
    }

    public PersonDeserializer() {
        this("type");
    }

    @Override
    public IPerson deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String className = object.get(typeElementName).getAsString();

        try {
            return gson.fromJson(jsonElement, (Type) Class.forName("tr.edu.iztech.pma.people." + className));
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
