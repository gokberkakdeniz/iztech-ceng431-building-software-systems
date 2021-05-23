package tr.edu.iztech.lol.data;

import java.util.ArrayList;
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
		descriptions.put(Assassin.class.getSimpleName(), "Assassins deal 3x instead of 2x when they hit critical damage.");
		descriptions.put(Cavalier.class.getSimpleName(), "Cavaliers take 20% less damage.");
		descriptions.put(Demolitionist.class.getSimpleName(), "Demolitionists deals extra damage (which is equal to 3x of their AD) every 1 of 3rd attack.");
		descriptions.put(GodKing.class.getSimpleName(), "God-Kings executes the enemy while enemy has 25% Health Point.");
		descriptions.put(Knight.class.getSimpleName(), "Knights parry the whole damage with 5% chance. This chance increases by 1.3x every time they attacked.");
		descriptions.put(Ranger.class.getSimpleName(), "Rangers increases their Critical Chance by 1.4x every time they attack. If they have 100% Critical Chance, they increase their Critical Damage by 1.15x.");
		descriptions.put(Sorcerer.class.getSimpleName(), "Sorcerers steal enemy’s Attack Damage by 5% every time they attack.");
		descriptions.put(DragonSlayer.class.getSimpleName(), "Dragonslayers execute the enemy by 2% chance. This chance gets multiplied by 1.4x every time they attack.");
		descriptions.put(Eternal.class.getSimpleName(), "Eternals refuse the die when they are below 0 health for the first time and revives back with 40% of his initial health.");
		descriptions.put(Forgotten.class.getSimpleName(), "Forgottens deal %8 of their health.");
		descriptions.put(Ironclad.class.getSimpleName(), "Ironclads ignores the damage and get healed as much as damage by 12.5% chance.");
		descriptions.put(Lightbringer.class.getSimpleName(), "Lightbringers take 2 times less damage when they are on their 35% health.");
		descriptions.put(Nightbringer.class.getSimpleName(), "Nightbringers deal 2 times more damage when they are on their 35% health.");
		descriptions.put(Trickster.class.getSimpleName(), "Trickster gamble, and deal extra damage by his Attack Damage to enemy or himself with 50% chance.");
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
