package tr.edu.iztech.orp.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.orp.models.User;

public class UserRepository implements IRepository<User, String> {
	private List<User> users;
	
	public UserRepository() {
		this.users = new LinkedList<>();
	}
	
	@Override
	public Optional<User> get(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}

	@Override
	public Optional<User> get(Predicate<User> predicate) {
		return users.stream().filter(predicate).findFirst();
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(users);
	}

	@Override
	public List<User> getAll(Predicate<User> predicate) {
		return users.stream().filter(predicate).collect(Collectors.toList());
	}

}
