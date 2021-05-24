package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.*;

/**
 * Hero factory using Abstract Factory Pattern
 */
public interface IHeroFactory {
	Assassin createAssassin();
	Cavalier createCavalier();
	Demolitionist createDemolitionist();
	GodKing createGodKing();
	Knight createKnight();
	Ranger createRanger();
	Sorcerer createSorcerer();
}
