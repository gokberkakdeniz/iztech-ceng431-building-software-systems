package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.data.CsvDataInitializer;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.entity.TeamDirector;
import tr.edu.iztech.teamstech.view.MainView;

public class Main {
    public static void main(String[] args) throws Exception {
        EntityDirector td = new TeamDirector(new CsvDataInitializer());
        MainView k = new MainView(td);
        k.show();
        k.kill();
    }
}
