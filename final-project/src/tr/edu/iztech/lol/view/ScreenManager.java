package tr.edu.iztech.lol.view;

import java.util.ArrayList;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.controllers.ILoginController;
import tr.edu.iztech.lol.controllers.LoginController;
import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IDatabase;
import tr.edu.iztech.lol.data.ISessionContainer;
import tr.edu.iztech.lol.data.SessionContainer;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.services.IUserService;
import tr.edu.iztech.lol.services.UserService;
import tr.edu.iztech.lol.utils.RandomUtils;
import tr.edu.iztech.lol.view.screen.ChampSelectPanel;
import tr.edu.iztech.lol.view.screen.LoginPanel;

public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private final IDatabase db = Database.getInstance();
	private final ISessionContainer sessionContainer = SessionContainer.getInstance();

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
	public void onLoginSuccess(Session session) {
		sessionContainer.setSession(session);
		onChampionSelectPanelRequested();
	}

	@Override
	public void onChampionSelectPanelRequested() {
		var a = RandomUtils.getHeroNames(5);
		var b = RandomUtils.getOriginNames(5);
		ChampSelectPanel champSelectPanel = new ChampSelectPanel(sessionContainer.getSession(), a, b);
		window.setContent(champSelectPanel);
	}
	

}
