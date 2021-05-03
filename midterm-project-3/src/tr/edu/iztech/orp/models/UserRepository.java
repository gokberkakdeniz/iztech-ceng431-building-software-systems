package tr.edu.iztech.orp.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.orp.data.IDataLoader;
import tr.edu.iztech.orp.data.IDataSaver;
import tr.edu.iztech.orp.enums.UserRepositoryEvent;
import tr.edu.iztech.orp.utils.AbstractObservable;

public class UserRepository extends AbstractObservable<UserRepository, UserRepositoryEvent> implements IRepository<User> {
	private List<User> users;
	private IDataSaver<User> dataSaver;
	
	public UserRepository(IDataLoader<User> dataLoader, IDataSaver<User> dataSaver) {
		this.users = new LinkedList<>(dataLoader.load());
		this.dataSaver = dataSaver;
	}
	
	@Override
	public Optional<User> get(Object username) {
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

	@Override
	public void save() {
		dataSaver.save(users);		
	}

}
