package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.data.CsvDataInitializer;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.entity.TestDirector;

public class MainTest {
    public static void main(String[] args) throws Exception {
        EntityDirector td = new TestDirector(new CsvDataInitializer());
        boolean ok = td.login("dilekozturk@iyte.edu.tr","1a2b");
        if (!ok) throw new Exception("login fail");
        td.getCurrentUser().getParticipatedTeams().forEach(t -> System.out.println(t.getName()));
    }
}
