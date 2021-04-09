package tr.edu.iztech.pma;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

import tr.edu.iztech.pma.data.DataContext;
import tr.edu.iztech.pma.io.*;
import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.*;
import tr.edu.iztech.pma.utils.TreeTraverser;
import tr.edu.iztech.pma.view.MainView;
import tr.edu.iztech.pma.view.Session;

public class Main {

    public static void main(String[] args) {
        DataContext context = new DataContext();
        Session.setContext(context);
        MainView view = new MainView();
        view.show();
        view.kill();
//        product_serde_test();
//        person_serde_test();
//        state_test();
    }

    private static void tree_test() {
        Product car = new Product(1, "car");
        Assembly engine = new Assembly(2, "engine");
        Part wheel = new Part(3, "wheel");
        car.add(engine);
        car.add(wheel);
        Part cylinder = new Part(4, "cylinder");
        engine.add(cylinder);

        TreeTraverser.traverse(car);

    }

    private static void state_test() {
        Product car = new Product(1, "car");
        Assembly engine = new Assembly(2, "engine");
        Part wheel = new Part(3, "wheel");
        car.add(engine);
        car.add(wheel);
        Part cylinder = new Part(4, "cylinder");
        engine.add(cylinder);

        cylinder.printState();
        cylinder.proceed();
        cylinder.proceed();
        wheel.proceed();
        wheel.proceed();
        cylinder.printState();
        engine.printState();
        car.printState();
    }

    private static void product_serde_test() {
        // NOTE: Expose etmediğimiz her şeyi atladı.
        Product car = new Product(1, "car");
        Assembly engine = new Assembly(2, "engine");
        Part wheel = new Part(3, "wheel");
        car.add(engine);
        car.add(wheel);
        Part cylinder = new Part(4, "cylinder");
        engine.add(cylinder);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(IProduct.class, new ProductDeserializer())
                .registerTypeAdapter(IProduct.class, new InterfaceSerializer<>())
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

        String inputString = gson.toJson(car);

        System.out.println(inputString);

        Product outCar = gson.fromJson(inputString, new TypeToken<IProduct>(){}.getType());
        System.out.println(outCar.getTitle());
    }

    private static void person_serde_test() {
        List<IPerson> people = Arrays.asList(new IPerson[] {
                new Admin("usr1", "pw1"),
//                new Employee("usr2", "pw2"),
//                new Manager("usr3", "pw3")
        });

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(IPerson.class, new PersonDeserializer())
                .setPrettyPrinting()
                .create();

        String inputString = gson.toJson(people);

        List<IPerson> outList = gson.fromJson(inputString, new TypeToken<List<IPerson>>(){}.getType());
        for (IPerson person : outList) {
            System.out.printf("%s - %s\n", person.getUsername(), person.getClass().getSimpleName());
        }
    }
}
