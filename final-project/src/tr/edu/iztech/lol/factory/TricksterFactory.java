package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.origin.Trickster;
import tr.edu.iztech.lol.origin.IOrigin;

public class TricksterFactory implements IHeroFactory {

	@Override
	public Assassin createAssassin() {
		IOrigin origin = new Trickster();
		Assassin hero = new Assassin(origin);

		return hero;
	}

	@Override
	public Cavalier createCavalier() {
		IOrigin origin = new Trickster();
		Cavalier hero = new Cavalier(origin);

		return hero;
	}

	@Override
	public Demolitionist createDemolitionist() {
		IOrigin origin = new Trickster();
		Demolitionist hero = new Demolitionist(origin);

		return hero;
	}

	@Override
	public GodKing createGodKing() {
		IOrigin origin = new Trickster();
		GodKing hero = new GodKing(origin);

		return hero;
	}

	@Override
	public Knight createKnight() {
		IOrigin origin = new Trickster();
		Knight hero = new Knight(origin);

		return hero;
	}

	@Override
	public Ranger createRanger() {
		IOrigin origin = new Trickster();
		Ranger hero = new Ranger(origin);

		return hero;
	}

	@Override
	public Sorcerer createSorcerer() {
		IOrigin origin = new Trickster();
		Sorcerer hero = new Sorcerer(origin);

		return hero;
	}
}
