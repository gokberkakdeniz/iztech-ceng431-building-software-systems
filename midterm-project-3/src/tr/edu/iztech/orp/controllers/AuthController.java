package tr.edu.iztech.orp.controllers;

import tr.edu.iztech.orp.data.IRepository;
import tr.edu.iztech.orp.exceptions.LoginFailedException;
import tr.edu.iztech.orp.models.User;

public class AuthController {
	private IRepository<User, String> userRepository;
	
	public AuthController(IRepository<User, String> userRepository) {
		this.userRepository = userRepository;
	}
	
	public User login(String username, String password) {
		return userRepository
				.get(u -> u.getUsername().equals(username) 
						&& u.checkPassword(password))
				.orElseThrow(LoginFailedException::new);
	}
}
