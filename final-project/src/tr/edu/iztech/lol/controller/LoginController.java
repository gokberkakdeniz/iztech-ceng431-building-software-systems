package tr.edu.iztech.lol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.services.IUserService;
import tr.edu.iztech.lol.view.IScreenManager;
import tr.edu.iztech.lol.view.screen.ILoginPanel;

public class LoginController implements ILoginController {
	private IUserService userService;
	private IScreenManager screenManager;
	private ILoginPanel view;
	
	public LoginController(ILoginPanel view, IScreenManager screenManager, IUserService userService) {
		this.view = view;
		this.userService = userService;
		this.screenManager = screenManager;
		
		this.view.addLoginButtonListener(loginButtonListener);
	}

	@Override
	public void destroy() {}
	
	private ActionListener loginButtonListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			view.hideError();
			
			var response = userService.login(view.getFirstUsername(), view.getSecondUsername());
			
			if (response.isOK()) {
				Session session = response.getResult();
				screenManager.onLoginSuccess(session);
			} else {
				view.showError(response.getException().getMessage());
			}
		}
	};
	
}
