package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.data.CsvDataInitializer;
import tr.edu.iztech.teamstech.data.CsvDataSaver;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.entity.TeamDirector;
import tr.edu.iztech.teamstech.view.MainView;

public class Main {
    public static void main(String[] args) {
        try {
        EntityDirector td = new TeamDirector(new CsvDataInitializer(), new CsvDataSaver());
        td.save();
        MainView k = new MainView(td);
        k.show();
        k.kill();
        td.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
