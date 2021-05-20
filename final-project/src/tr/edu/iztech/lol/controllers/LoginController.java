package tr.edu.iztech.lol.controllers;

import tr.edu.iztech.lol.exception.UserNotFoundException;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.services.IUserService;
import tr.edu.iztech.lol.view.IScreenManager;

public class LoginController implements ILoginController {
	private IUserService userService;
	private IScreenManager screenManager;
	
	public LoginController(IScreenManager screenManager, IUserService userService) {
		this.userService = userService;
		this.screenManager = screenManager;
	}

	@Override
	public void login(String username1, String username2) {
		var response = userService.login(username1, username2);
		
//		if (!response.isOK()) throw response.getException();
		
		Session session = response.getResult();
		screenManager.onLoginSuccess(null);
	}

	@Override
	public void destroy() {}
	
}
