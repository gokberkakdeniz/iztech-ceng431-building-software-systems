package tr.edu.iztech.lol.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.model.MatchRecord;

public class MatchRecordRepository implements IRepository<MatchRecord> {
	private List<MatchRecord> data;
	private IDataSaver<MatchRecord> saver;


	public MatchRecordRepository(IDataLoader<MatchRecord> loader, IDataSaver<MatchRecord> saver) {
		this.data = loader.load();
		this.saver = saver;
	}
	
	@Override
	public Optional<MatchRecord> get(Object id) {
		return data.stream().filter(r -> ((Long) r.getId()).equals(id)).findFirst();
	}

	@Override
	public Optional<MatchRecord> get(Predicate<MatchRecord> predicate) {
		return data.stream().filter(predicate).findFirst();
	}

	@Override
	public List<MatchRecord> getAll() {
		return new ArrayList<>(data);
	}

	@Override
	public List<MatchRecord> getAll(Predicate<MatchRecord> predicate) {
		return data.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public boolean add(MatchRecord model) {
		return data.add(model);
	}
	
	@Override
	public void save() {
		saver.save(data);
	}
}
