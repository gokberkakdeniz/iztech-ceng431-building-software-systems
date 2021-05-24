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
	
	/**
	 * Champion selection done handler
	 * 
	 * @param modelLeft left user's selection
	 * @param modelRight right user's selection
	 */
	void onChampionSelectDone(ChampionSelectModel modelLeft, ChampionSelectModel modelRight);
	
	/**
	 * Statistics page open handler
	 */
	void onStatisticsPanelRequested();
	
	/**
	 * Logout handler
	 */
	void onLogoutRequested();
}