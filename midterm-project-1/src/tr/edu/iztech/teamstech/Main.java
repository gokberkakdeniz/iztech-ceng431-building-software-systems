package tr.edu.iztech.teamstech;

import tr.edu.iztech.teamstech.data.DataInitializer;
import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.entity.TestDirector;
import tr.edu.iztech.teamstech.view.MainView;

public class Main {
    public static void main(String[] args) throws Exception {
//        MainView k = new MainView();
//        k.show();

        EntityDirector td = new TestDirector();
        DataInitializer.init(td);
    }
}
