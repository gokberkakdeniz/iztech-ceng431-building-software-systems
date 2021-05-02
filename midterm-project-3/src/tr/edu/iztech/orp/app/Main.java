package tr.edu.iztech.orp.app;

import java.awt.EventQueue;

import tr.edu.iztech.orp.data.IDataLoader;
import tr.edu.iztech.orp.data.OutfitLoader;
import tr.edu.iztech.orp.data.UserLoader;
import tr.edu.iztech.orp.enums.OutfitColor;
import tr.edu.iztech.orp.enums.OutfitGender;
import tr.edu.iztech.orp.enums.OutfitSize;
import tr.edu.iztech.orp.enums.OutfitType;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.models.UserRepository;
import tr.edu.iztech.orp.views.IScreenManager;
import tr.edu.iztech.orp.views.MainWindow;
import tr.edu.iztech.orp.views.ScreenManager;

public class Main {
	public static void main(String[] args) {
		IDataLoader<User> userLoader = new UserLoader("./users.xml");
		UserRepository userRepo = new UserRepository(userLoader);
		
		IDataLoader<Outfit> outfitLoader = new OutfitLoader("./outfits.json");
		OutfitRepository outfitRepo = new OutfitRepository(outfitLoader);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					IScreenManager screenManager = new ScreenManager(window, userRepo, outfitRepo);
					screenManager.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
