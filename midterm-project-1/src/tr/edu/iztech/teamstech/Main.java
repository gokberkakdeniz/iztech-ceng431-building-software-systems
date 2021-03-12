package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.fileio.CsvIO;
import tr.edu.iztech.teamstech.fileio.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileIO<User> csvio = new CsvIO<User>(new File("./userList.csv"), User.class);
        User user = csvio.read(5);
        System.out.println(user.userType);
        System.out.println(user.userName);
        System.out.println(user.userId);
        System.out.println(user.password);
        System.out.println(user.teamId);
    }
}
