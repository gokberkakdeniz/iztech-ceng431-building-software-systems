package tr.edu.iztech.lol.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.origin.*;

public class RandomUtils {
    private static Random rand = new Random();
    private static List<Class<? extends IHero>> heroClasses = Arrays.asList(Assasin.class, 
																	  		Cavalier.class, 
																	  		Demolitionist.class, 
																	  		GodKing.class,
																	  		Knight.class, 
																	  		Ranger.class, 
																	  		Sorcerer.class);
    private static List<Class<? extends IOrigin>> originClasses = Arrays.asList(DragonSlayer.class, 
																		  		Eternal.class, 
																		  		Forgotten.class, 
																		  		Ironclad.class,
																		  		Lightbringer.class, 
																		  		Nightbringer.class, 
																		  		Trickster.class);
	
	public static int getInteger(int from, int to) {
		return from + rand.nextInt(to);
	}
	
	public static double getDouble() {
		return rand.nextDouble();
	}
	
	public static List<String> getHeroNames(int size) {
		Collections.shuffle(heroClasses);
		return heroClasses.subList(0, size).stream().map(Class::getSimpleName).collect(Collectors.toList());
	}
	
	public static List<String> getOriginNames(int size) {
		Collections.shuffle(originClasses);
		return heroClasses.subList(0, size).stream().map(Class::getSimpleName).collect(Collectors.toList());
	}
}
