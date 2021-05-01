package tr.edu.iztech.orp.views;

import tr.edu.iztech.orp.models.User;

public interface IScreenManager {
	void run();
	void onLoginSuccess(User user);
	void onPageChanged(MenuModel model);
	void onLogout();
}