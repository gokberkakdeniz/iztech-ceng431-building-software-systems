package tr.edu.iztech.orp.app;

import java.awt.EventQueue;

import tr.edu.iztech.orp.data.IDataLoader;
import tr.edu.iztech.orp.data.IRepository;
import tr.edu.iztech.orp.data.OutfitLoader;
import tr.edu.iztech.orp.data.OutfitRepository;
import tr.edu.iztech.orp.data.UserLoader;
import tr.edu.iztech.orp.data.UserRepository;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.IScreenManager;
import tr.edu.iztech.orp.views.MainWindow;
import tr.edu.iztech.orp.views.ScreenManager;

public class Main {
	public static void main(String[] args) {
		IDataLoader<User> userLoader = new UserLoader("./users.xml");
		IRepository<User> userRepo = new UserRepository(userLoader);
		
		IDataLoader<Outfit> outfitLoader = new OutfitLoader("./outfits.json");
		IRepository<Outfit> outfitRepo = new OutfitRepository(outfitLoader);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					IScreenManager screenManager = new ScreenManager(window, userRepo);
					screenManager.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
