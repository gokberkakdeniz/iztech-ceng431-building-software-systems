package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.data.CsvDataInitializer;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.entity.TestDirector;

public class MainTest {
    public static void main(String[] args) throws Exception {
        EntityDirector td = new TestDirector(new CsvDataInitializer());

    }
}
