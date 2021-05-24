package tr.edu.iztech.lol.view;

import tr.edu.iztech.lol.controller.ChampionFightController;
import tr.edu.iztech.lol.controller.ChampionSelectController;
import tr.edu.iztech.lol.controller.IController;
import tr.edu.iztech.lol.controller.LoginController;
import tr.edu.iztech.lol.controller.StatisticsController;
import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IDatabase;
import tr.edu.iztech.lol.data.ISessionContainer;
import tr.edu.iztech.lol.data.SessionContainer;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.model.TopWinnersModel;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.services.ChampionFightService;
import tr.edu.iztech.lol.services.ChampionSelectService;
import tr.edu.iztech.lol.services.IChampionFightService;
import tr.edu.iztech.lol.services.IChampionSelectService;
import tr.edu.iztech.lol.services.IStatisticsService;
import tr.edu.iztech.lol.services.IUserService;
import tr.edu.iztech.lol.services.StatisticsService;
import tr.edu.iztech.lol.services.UserService;
import tr.edu.iztech.lol.view.screen.ChampionFightPanel;
import tr.edu.iztech.lol.view.screen.ChampionSelectPanel;
import tr.edu.iztech.lol.view.screen.LoginPanel;
import tr.edu.iztech.lol.view.screen.StatisticsPanel;

public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private final IDatabase db = Database.getInstance();
	private final ISessionContainer sessionContainer = SessionContainer.getInstance();
	private IController controller;
	
	public ScreenManager(MainWindow window) {
		this.window = window;
	}
	
	public void run() {
		showLoginScreen();
		
		window.setVisible(true);
	}
	
	private void showLoginScreen() {
		destroyController();

		IUserService service = new UserService(db.getUserRepository());
		LoginPanel view = new LoginPanel();
		controller = new LoginController(view, this, service);
		window.setContent(view);
	}
	
	@Override
	public void onLoginSuccess(Session session) {
		destroyController();

		sessionContainer.setSession(session);
		
		onChampionSelectPanelRequested();
	}

	@Override
	public void onChampionSelectPanelRequested() {
		destroyController();

		User user1 = sessionContainer.getSession().getUser1();
		User user2 = sessionContainer.getSession().getUser2();
		
		IChampionSelectService service = new ChampionSelectService(db.getDescriptionRepository());
		
		ChampionSelectModel modelLeft = service.getAvailableChampions(user1).getResult();
		ChampionSelectModel modelRight = service.getAvailableChampions(user2).getResult();
		
		ChampionSelectPanel view = new ChampionSelectPanel(modelLeft, modelRight);
		
		controller = new ChampionSelectController(view, modelLeft, modelRight, this);
		
		window.setContent(view);
	}

	@Override
	public void onChampionSelectDone(ChampionSelectModel selectionLeft, ChampionSelectModel selectionRight) {
		destroyController();
		
		IChampionFightService service = new ChampionFightService(db.getMatchRecordRepository());
		Match model = service.createMatch(selectionLeft.getUser(), selectionLeft.getSelectedHero(), selectionLeft.getSelectedOrigin(), 
										  selectionRight.getUser(), selectionRight.getSelectedHero(), selectionRight.getSelectedOrigin())
				.getResult();
		ChampionFightPanel view = new ChampionFightPanel(model);
		new ChampionFightController(view, model, this);
		
		window.setContent(view);
		
		service.startMatch(model);
	}
	
	@Override
	public void onStatisticsPanelRequested() {
		destroyController();
		
		IStatisticsService service = new StatisticsService(db.getUserRepository(), db.getMatchRecordRepository());

		TopWinnersModel topWinnersModel = service.getTopWinnersModel().getResult();
		MatchRecordsModel matchRecordsModel = service.getMatchRecordsModel().getResult();

		StatisticsPanel view = new StatisticsPanel(topWinnersModel, matchRecordsModel);

		controller = new StatisticsController(view, topWinnersModel, matchRecordsModel, service, this);
		
		window.setContent(view);
	}
	
	private void destroyController() {
		if (controller != null) controller.destroy();
	}

	@Override
	public void onLogoutRequested() {
		sessionContainer.setSession(null);
		showLoginScreen();
	}
}
