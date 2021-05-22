package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.data.IRepository;
import tr.edu.iztech.lol.exception.LoginException;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.model.User;

public class UserService implements IUserService {
	private final IRepository<User> userRepository;
	
	public UserService(IRepository<User> userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public IResponse<Session, LoginException> login(String username1, String username2) {
		if (username1 == null || username1.length() < 5)
			return new Response<>(new LoginException("The first username must be longer than 5 characters."));
		
		if (username2 == null || username2.length() < 5)
			return new Response<>(new LoginException("The second username must be longer than 5 characters."));
		
		if (username1.equals(username2))
			return new Response<>(new LoginException("The usernames must not be equal."));
		

		User user1 = userRepository.get(username1).orElse(null);
		User user2 = userRepository.get(username2).orElse(null);
				
		if (user1 == null) {
			user1 = new User(username1);
			userRepository.add(user1);
		}
		
		if (user2 == null) {
			user2 =  new User(username2);
			userRepository.add(user2);
		}
		
		return new Response<>(new Session(user1, user2));
	}
}
