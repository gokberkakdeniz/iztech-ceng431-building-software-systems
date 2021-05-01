package tr.edu.iztech.orp.views;

import tr.edu.iztech.orp.controllers.LoginController;
import tr.edu.iztech.orp.data.IRepository;
import tr.edu.iztech.orp.models.User;

public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private IRepository<User> userRepo;
	private User user;

	public ScreenManager(MainWindow window, IRepository<User> userRepo) {
		this.window = window;
		this.userRepo = userRepo;
	}
	
	public void run() {
		showLoginScreen();
		window.setVisible(true);
	}
	
	public void onLoginSuccess(User user) {
		this.user = user;
		window.setHeader(new HeaderPanel(this));
		showHomeScreen();
	}
	
	public void onLogout() {
		this.user = null;
		window.setHeader(null);
		showLoginScreen();
	}
	
	public void onPageChanged(MenuModel model) {
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
		window.setContent(new HomePanel());
	}
	
	private void showCollectionsScreen() {
		window.setContent(new CollectionsPanel());
	}
	
	private void showFollowedUsersScreen() {
		window.setContent(new FollowedUsersPanel());
	}
	
	private void showStatisticsScreen() {
		window.setContent(new StatisticsPanel());
	}
}
