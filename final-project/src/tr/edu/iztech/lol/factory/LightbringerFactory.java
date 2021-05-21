package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.origin.IOrigin;
import tr.edu.iztech.lol.origin.Lightbringer;

public class LightbringerFactory implements IHeroFactory {

	@Override
	public Assassin createAssassin() {
		IOrigin origin = new Lightbringer();
		Assassin hero = new Assassin(origin);

		return hero;
	}

	@Override
	public Cavalier createCavalier() {
		IOrigin origin = new Lightbringer();
		Cavalier hero = new Cavalier(origin);

		return hero;
	}

	@Override
	public Demolitionist createDemolitionist() {
		IOrigin origin = new Lightbringer();
		Demolitionist hero = new Demolitionist(origin);

		return hero;
	}

	@Override
	public GodKing createGodKing() {
		IOrigin origin = new Lightbringer();
		GodKing hero = new GodKing(origin);

		return hero;
	}

	@Override
	public Knight createKnight() {
		IOrigin origin = new Lightbringer();
		Knight hero = new Knight(origin);

		return hero;
	}

	@Override
	public Ranger createRanger() {
		IOrigin origin = new Lightbringer();
		Ranger hero = new Ranger(origin);

		return hero;
	}

	@Override
	public Sorcerer createSorcerer() {
		IOrigin origin = new Lightbringer();
		Sorcerer hero = new Sorcerer(origin);

		return hero;
	}


}
