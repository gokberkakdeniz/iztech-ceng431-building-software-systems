package tr.edu.iztech.pma;

import tr.edu.iztech.pma.data.DataContext;
import tr.edu.iztech.pma.data.DataLoader;
import tr.edu.iztech.pma.data.DataSaver;
import tr.edu.iztech.pma.view.MainView;
import tr.edu.iztech.pma.view.Session;

import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        Path path = Path.of("./data.json");
        DataContext context = new DataContext(new DataLoader(path), new DataSaver(path));
        Session.setContext(context);
        MainView view = new MainView();
        view.show();
        view.kill();
        context.save();
    }
}
