package tr.edu.iztech.orp.controllers;

import tr.edu.iztech.orp.exceptions.LoginFailedException;

public interface ILoginController {
	public void login(String username, String password) throws LoginFailedException;
}
