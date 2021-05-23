package tr.edu.iztech.lol.view;

import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.Session;


/**
 * Handles view changes
 */
public interface IScreenManager {
	/**
	 * Starts main window
	 */
	void run();
	
	/**
	 * Successful login handler
	 * 
	 * @param user logged in user
	 */
	void onLoginSuccess(Session session);
	
	/**
	 * Page change handler
	 * 
	 * @param model new screen name
	 */
	void onChampionSelectPanelRequested();

	void onChampionSelectDone(ChampionSelectModel modelLeft, ChampionSelectModel modelRight);

	void onStatisticsPanelRequested();
	
}