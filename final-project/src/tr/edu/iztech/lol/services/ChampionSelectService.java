package tr.edu.iztech.lol.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IRepository;
import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.model.AvailableChampionsModel;
import tr.edu.iztech.lol.origin.DragonSlayer;
import tr.edu.iztech.lol.origin.Eternal;
import tr.edu.iztech.lol.origin.Forgotten;
import tr.edu.iztech.lol.origin.IOrigin;
import tr.edu.iztech.lol.origin.Ironclad;
import tr.edu.iztech.lol.origin.Lightbringer;
import tr.edu.iztech.lol.origin.Nightbringer;
import tr.edu.iztech.lol.origin.Trickster;

public class ChampionSelectService implements IChampionSelectService {
    private List<Class<? extends IHero>> heroClasses;
	private List<Class<? extends IOrigin>> originClasses;
	private IRepository<String> descriptionRepository = Database.getInstance().getDescriptionRepository();
	
	public ChampionSelectService() {
		this.heroClasses = Arrays.asList(Assassin.class, Cavalier.class, Demolitionist.class, 
		  		 						 GodKing.class, Knight.class, Ranger.class,
		  		 						 Sorcerer.class);
		this.originClasses = Arrays.asList(DragonSlayer.class, Eternal.class, Forgotten.class, 
										   Ironclad.class, Lightbringer.class, Nightbringer.class, 
										   Trickster.class);
		Collections.shuffle(heroClasses);
		Collections.shuffle(originClasses);
	}
	
	@Override
	public IResponse<AvailableChampionsModel, NeverOccuredException> getAvailableChampions(int size) {
		AvailableChampionsModel model = new AvailableChampionsModel();
		
		List<String> heros = heroClasses.subList(0, size).stream().map(Class::getSimpleName).collect(Collectors.toList());
		List<String> origins =  originClasses.subList(0, size).stream().map(Class::getSimpleName).collect(Collectors.toList());
		
		heros.forEach(name -> model.addHero(name, descriptionRepository.get(name).get()));
		origins.forEach(name -> model.addOrigin(name, descriptionRepository.get(name).get()));
		
		return new Response<>(model);
	}
	
}
