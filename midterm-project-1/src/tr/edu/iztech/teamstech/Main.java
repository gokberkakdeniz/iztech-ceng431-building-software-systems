package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.io.CsvDatabase;
import tr.edu.iztech.teamstech.io.KeyboardReader;
import tr.edu.iztech.teamstech.view.MainView;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        MainView k = new MainView();
        k.show();
//        List<User> users = new CsvDatabase<>(User.class).load(new File("./userList.csv"));
//        System.out.println(users.size());
//        KeyboardReader reader = new KeyboardReader();
//
//        KeyboardReader.Options options = new KeyboardReader.Options("ne yapcan", new String[] {
//                "ekle", "çıkar", "sil"
//        }, true);
//        options.printOptions();
//        reader.promptInteger("sfsdfsdfsd", options.getPredicate());
//        reader.close();
    }
}
