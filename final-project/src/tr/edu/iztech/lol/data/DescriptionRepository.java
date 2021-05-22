package tr.edu.iztech.lol.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.origin.DragonSlayer;
import tr.edu.iztech.lol.origin.Eternal;
import tr.edu.iztech.lol.origin.Forgotten;
import tr.edu.iztech.lol.origin.Ironclad;
import tr.edu.iztech.lol.origin.Lightbringer;
import tr.edu.iztech.lol.origin.Nightbringer;
import tr.edu.iztech.lol.origin.Trickster;

public class DescriptionRepository implements IRepository<String> {
	private static Map<String, String> descriptions = new HashMap<String, String>();

	static {
		descriptions.put(Assassin.class.getSimpleName(), "Assassin");
		descriptions.put(Cavalier.class.getSimpleName(), "Cavalier");
		descriptions.put(Demolitionist.class.getSimpleName(), "Demolitionist");
		descriptions.put(GodKing.class.getSimpleName(), "GodKing");
		descriptions.put(Knight.class.getSimpleName(), "Knight");
		descriptions.put(Ranger.class.getSimpleName(), "Ranger");
		descriptions.put(Sorcerer.class.getSimpleName(), "Sorcerer");
		descriptions.put(DragonSlayer.class.getSimpleName(), "DragonSlayer");
		descriptions.put(Eternal.class.getSimpleName(), "Eternal");
		descriptions.put(Forgotten.class.getSimpleName(), "Forgotten");
		descriptions.put(Ironclad.class.getSimpleName(), "Ironclad");
		descriptions.put(Lightbringer.class.getSimpleName(), "Lightbringer");
		descriptions.put(Nightbringer.class.getSimpleName(), "Nightbringer");
		descriptions.put(Trickster.class.getSimpleName(), "Trickster");
	}
	
	@Override
	public Optional<String> get(Object id) {
		return Optional.ofNullable(descriptions.get(id));
	}

	@Override
	public Optional<String> get(Predicate<String> predicate) {
		String key = descriptions.keySet().stream().filter(predicate).findFirst().orElseGet(null);
		return Optional.ofNullable(key != null ? descriptions.get(key) : null);
	}

	@Override
	public List<String> getAll() {
		return new ArrayList<>(descriptions.values());
	}

	@Override
	public List<String> getAll(Predicate<String> predicate) {
		return descriptions.entrySet().stream().filter(e -> predicate.test(e.getKey())).map(e -> e.getValue()).collect(Collectors.toList());
	}

	@Override
	public boolean add(String model) {
		return false;
	}

	@Override
	public void save() {}

}
