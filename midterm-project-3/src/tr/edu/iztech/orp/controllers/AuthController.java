package tr.edu.iztech.orp.controllers;

import tr.edu.iztech.orp.data.IRepository;
import tr.edu.iztech.orp.models.User;

public class AuthController {
	private IRepository<User, String> userRepository;
	
	public AuthController(IRepository<User, String> userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean login(String username, String password) {
		return false;
	}
}
