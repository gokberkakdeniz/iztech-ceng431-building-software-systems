package tr.edu.iztech.orp.controllers;

import tr.edu.iztech.orp.exceptions.LoginFailedException;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.IScreenManager;

public class LoginController implements IController {
	private IRepository<User> userRepository;
	private IScreenManager screenManager;
	
	public LoginController(IScreenManager screenManager, IRepository<User> userRepository) {
		this.screenManager = screenManager;
		this.userRepository = userRepository;
	}
	
	public void login(String username, String password) throws LoginFailedException {
		User user = userRepository
				.get(u -> u.getUsername().equals(username) 
						&& u.checkPassword(password))
				.orElseThrow(LoginFailedException::new);
		
		screenManager.onLoginSuccess(user);
	}

	@Override
	public void destroy() {}
}
