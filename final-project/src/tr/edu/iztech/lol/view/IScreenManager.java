package tr.edu.iztech.lol.view;

import tr.edu.iztech.lol.model.User;


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
	void onLoginSuccess(User user);
	
	/**
	 * Page change handler
	 * 
	 * @param model new screen name
	 */
	void onPageChanged();
	
	/**
	 * Logout handler
	 */
	void onLogout();
}