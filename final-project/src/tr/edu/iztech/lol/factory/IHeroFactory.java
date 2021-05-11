package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.*;

public interface IHeroFactory {
	Assasin createAssasin();
	Cavalier createCavalier();
	Demolitionist createDemolitionist();
	GodKing createGodKing();
	Knight createKnight();
	Ranger createRanger();
	Sorcerer createSorcerer();
}
