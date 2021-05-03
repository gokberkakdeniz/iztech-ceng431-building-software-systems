package tr.edu.iztech.orp.app;

import java.awt.EventQueue;

import javax.xml.parsers.ParserConfigurationException;

import tr.edu.iztech.orp.data.IDataLoader;
import tr.edu.iztech.orp.data.IDataMonitoredSaver;
import tr.edu.iztech.orp.data.OutfitLoader;
import tr.edu.iztech.orp.data.OutfitMonitoredSaver;
import tr.edu.iztech.orp.data.OutfitSaver;
import tr.edu.iztech.orp.data.Statistics;
import tr.edu.iztech.orp.data.UserLoader;
import tr.edu.iztech.orp.data.UserMonitoredSaver;
import tr.edu.iztech.orp.data.UserSaver;
import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.models.UserRepository;
import tr.edu.iztech.orp.views.IScreenManager;
import tr.edu.iztech.orp.views.MainWindow;
import tr.edu.iztech.orp.views.ScreenManager;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException {
		IDataLoader<User> userLoader = new UserLoader("./users.xml");
		UserSaver userSaver = new UserSaver("./users.xml");
		UserRepository userRepo = new UserRepository(userLoader, userSaver);
		IDataMonitoredSaver<User, UserEvent> userMonitoredSaver = new UserMonitoredSaver(userRepo);
		
		IDataLoader<Outfit> outfitLoader = new OutfitLoader("./outfits.json");
		OutfitSaver outfitSaver = new OutfitSaver("./outfits.json");
		OutfitRepository outfitRepo = new OutfitRepository(outfitLoader, outfitSaver);
		IDataMonitoredSaver<Outfit, OutfitEvent> outfitMonitoredSaver = new OutfitMonitoredSaver(outfitRepo);
				
		Session.setStatistics(new Statistics(userRepo, outfitRepo));
		
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
