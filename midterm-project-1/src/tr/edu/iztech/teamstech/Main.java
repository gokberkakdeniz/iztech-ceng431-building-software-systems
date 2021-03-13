package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.fileio.CsvDatabase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> users = new CsvDatabase<>(User.class).load(new File("./userList.csv"));
        System.out.println(users.size());
    }
}
