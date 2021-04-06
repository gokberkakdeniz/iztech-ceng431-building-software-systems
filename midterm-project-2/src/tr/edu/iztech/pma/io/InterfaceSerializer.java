package tr.edu.iztech.pma.io;

import com.google.gson.*;

import java.lang.reflect.Type;

// source: https://stackoverflow.com/a/15557654/8521693
public class InterfaceSerializer<T> implements JsonSerializer<T> {
    public JsonElement serialize(T link, Type type, JsonSerializationContext context) {
        // Odd Gson quirk
        // not smart enough to use the actual type rather than the interface
        return context.serialize(link, link.getClass());
    }
}
