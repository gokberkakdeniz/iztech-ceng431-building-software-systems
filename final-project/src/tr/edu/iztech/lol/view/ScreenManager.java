package tr.edu.iztech.lol.view;

import tr.edu.iztech.lol.controllers.ILoginController;
import tr.edu.iztech.lol.controllers.LoginController;
import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IDatabase;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.services.IUserService;
import tr.edu.iztech.lol.services.UserService;
import tr.edu.iztech.lol.view.screen.LoginPanel;

public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private final IDatabase db = Database.getInstance();
	
	public ScreenManager(MainWindow window) {
		this.window = window;
	}
	
	public void run() {
		showLoginScreen();
		window.setVisible(true);
	}
	
	private void showLoginScreen() {
		IUserService userService = new UserService(db.getUserRepository());
		ILoginController loginController = new LoginController(this, userService);
		LoginPanel loginPanel = new LoginPanel(loginController);
		window.setContent(loginPanel);
	}
	
	@Override
	public void onLoginSuccess(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLogout() {
		// TODO Auto-generated method stub
		
	}

}
