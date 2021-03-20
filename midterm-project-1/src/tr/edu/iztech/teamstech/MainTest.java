package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.data.CsvDataInitializer;
import tr.edu.iztech.teamstech.data.CsvDataSaver;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.entity.TeamDirector;

public class MainTest {
    public static void main(String[] args) throws Exception {
        EntityDirector td = new TeamDirector(new CsvDataInitializer(), new CsvDataSaver());
//        td.findTeams(v->true).forEach(System.out::println);
//        td.findUsers(v -> true).forEach(System.out::println);
        (new CsvDataSaver()).save(td);

    }
}
