package tr.edu.iztech.lol.view;

import java.util.ArrayList;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.controller.ChampionSelectController;
import tr.edu.iztech.lol.controller.IChampionSelectController;
import tr.edu.iztech.lol.controller.ILoginController;
import tr.edu.iztech.lol.controller.LoginController;
import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IDatabase;
import tr.edu.iztech.lol.data.ISessionContainer;
import tr.edu.iztech.lol.data.SessionContainer;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.services.ChampionSelectService;
import tr.edu.iztech.lol.services.IChampionSelectService;
import tr.edu.iztech.lol.services.IUserService;
import tr.edu.iztech.lol.services.UserService;
import tr.edu.iztech.lol.utils.RandomUtils;
import tr.edu.iztech.lol.view.screen.ChampionSelectPanel;
import tr.edu.iztech.lol.view.screen.IChampionSelectPanel;
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
		IUserService service = new UserService(db.getUserRepository());
		LoginPanel view = new LoginPanel();
		ILoginController controller = new LoginController(view, this, service);
		window.setContent(view);
	}
	
	@Override
	public void onLoginSuccess(Session session) {
		sessionContainer.setSession(session);
		
		onChampionSelectPanelRequested();
	}

	@Override
	public void onChampionSelectPanelRequested() {
		User user1 = sessionContainer.getSession().getUser1();
		User user2 = sessionContainer.getSession().getUser2();
		
		IChampionSelectService service = new ChampionSelectService();
		
		ChampionSelectModel modelLeft = service.getAvailableChampions(user1).getResult();
		ChampionSelectModel modelRight = service.getAvailableChampions(user2).getResult();
		
		ChampionSelectPanel view = new ChampionSelectPanel(modelLeft, modelRight);
		
		new ChampionSelectController(view, modelLeft, modelRight, this, service);
		
		window.setContent(view);
	}
	

}
