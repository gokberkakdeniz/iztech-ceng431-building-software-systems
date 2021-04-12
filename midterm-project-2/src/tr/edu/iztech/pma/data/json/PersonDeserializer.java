package tr.edu.iztech.pma.data.json;

import com.google.gson.*;
import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.product.IProduct;

import java.lang.reflect.Type;

/**
 * Gson library extension for deserialize IPerson
 */
public class PersonDeserializer implements JsonDeserializer<IPerson> {
    private final String typeElementName;
    private final Gson gson;
    private final ISerializationRepository<Integer,IProduct> productRepo;

    public PersonDeserializer(String typeElementName, ISerializationRepository<Integer,IProduct> productRepo) {
        this.typeElementName = typeElementName;
        this.productRepo = productRepo;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(IProduct.class, new ProductDeserializer(productRepo))
                .create();
    }

    public PersonDeserializer(ISerializationRepository<Integer,IProduct> productRepo) {
        this("type", productRepo);
    }

    @Override
    public IPerson deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String className = object.get(typeElementName).getAsString();

        // Employee has IProduct which is deserialized before. We need to find it to keep references same.
        if (className.equals("Employee")) {
            String username = object.get("username").getAsString();
            String password = object.get("password").getAsString();
            int productId = object.get("productId").getAsInt();

            return new Employee(username, password, productRepo.get(productId));
        }

        try {
            return gson.fromJson(jsonElement, (Type) Class.forName("tr.edu.iztech.pma.people." + className));
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
