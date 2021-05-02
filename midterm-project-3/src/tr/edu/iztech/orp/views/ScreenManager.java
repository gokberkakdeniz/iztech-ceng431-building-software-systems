package tr.edu.iztech.orp.views;

import javax.swing.JPanel;

import tr.edu.iztech.orp.app.Session;
import tr.edu.iztech.orp.controllers.CollectionsController;
import tr.edu.iztech.orp.controllers.HomeController;
import tr.edu.iztech.orp.controllers.IController;
import tr.edu.iztech.orp.controllers.LoginController;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.models.UserRepository;

public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private JPanel view;
	private IController controller;
	
	private UserRepository userRepo;
	private OutfitRepository outfitRepo;

	public ScreenManager(MainWindow window, UserRepository userRepo, OutfitRepository outfitRepo) {
		this.window = window;
		this.userRepo = userRepo;
		this.outfitRepo = outfitRepo;
	}
	
	public void run() {
		showLoginScreen();
		window.setVisible(true);
	}
	
	public void onLoginSuccess(User user) {
		Session.setUser(user);
		window.setHeader(new HeaderPanel(this, user));
		showHomeScreen();
	}
	
	public void onLogout() {
		Session.setUser(null);
		window.setHeader(null);
		showLoginScreen();
	}
	
	public void onPageChanged(MenuModel model) {
		controller.destroy();
		
		switch (model) {
			case HOME:
				showHomeScreen();
				break;
			case COLLECTIONS:
				showCollectionsScreen();
				break;
			case FOLLOWED_USERS:
				showFollowedUsersScreen();
				break;
			case STATISTICS:
				showStatisticsScreen();
				break;
			default:
				break;
		}
	}
	
	private void showLoginScreen() {
		window.setContent(new LoginPanel(new LoginController(this, userRepo)));
	}
	
	private void showHomeScreen() {
		this.view = new HomePanel(outfitRepo);
		this.controller = new HomeController((HomePanel) view, outfitRepo);
		
		window.setContent(view);
	}
	
	private void showCollectionsScreen() {
		User model = Session.getUser();
		this.view = new CollectionsPanel(model);
		this.controller = new CollectionsController((CollectionsPanel) view, model);
		
		window.setContent(view);
	}
	
	private void showFollowedUsersScreen() {
		window.setContent(new FollowedUsersPanel(Session.getUser()));
	}
	
	private void showStatisticsScreen() {
		window.setContent(new StatisticsPanel());
	}
}
