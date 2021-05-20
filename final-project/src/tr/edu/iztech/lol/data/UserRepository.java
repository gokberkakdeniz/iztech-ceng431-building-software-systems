package tr.edu.iztech.lol.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.model.User;

public class UserRepository implements IRepository<User> {
	private List<User> data;
	private IDataSaver<User> saver;


	public UserRepository(IDataLoader<User> loader, IDataSaver<User> saver) {
		this.data = loader.load();
		this.saver = saver;
	}
	
	@Override
	public Optional<User> get(Object id) {
		return data.stream().filter(r -> r.getUsername().equals(id)).findFirst();
	}

	@Override
	public Optional<User> get(Predicate<User> predicate) {
		return data.stream().filter(predicate).findFirst();
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(data);
	}

	@Override
	public List<User> getAll(Predicate<User> predicate) {
		return data.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public boolean add(User model) {
		return data.add(model);
	}

	@Override
	public void save() {
		saver.save(data);
	}

}
