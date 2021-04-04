package tr.edu.iztech.pma;
import com.google.gson.*;
import tr.edu.iztech.pma.people.Admin;
import tr.edu.iztech.pma.people.People;

public class Main {

    public static void main(String[] args) {
        People admin = new Admin("usr", "pw");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(admin));
    }
}
