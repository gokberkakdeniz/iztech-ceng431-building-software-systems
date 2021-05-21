package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.origin.Eternal;
import tr.edu.iztech.lol.origin.IOrigin;

public class EternalFactory implements IHeroFactory {

	@Override
	public Assassin createAssassin() {
		IOrigin origin = new Eternal();
		Assassin hero = new Assassin(origin);

		return hero;
	}

	@Override
	public Cavalier createCavalier() {
		IOrigin origin = new Eternal();
		Cavalier hero = new Cavalier(origin);

		return hero;
	}

	@Override
	public Demolitionist createDemolitionist() {
		IOrigin origin = new Eternal();
		Demolitionist hero = new Demolitionist(origin);

		return hero;
	}

	@Override
	public GodKing createGodKing() {
		IOrigin origin = new Eternal();
		GodKing hero = new GodKing(origin);

		return hero;
	}

	@Override
	public Knight createKnight() {
		IOrigin origin = new Eternal();
		Knight hero = new Knight(origin);

		return hero;
	}

	@Override
	public Ranger createRanger() {
		IOrigin origin = new Eternal();
		Ranger hero = new Ranger(origin);

		return hero;
	}

	@Override
	public Sorcerer createSorcerer() {
		IOrigin origin = new Eternal();
		Sorcerer hero = new Sorcerer(origin);

		return hero;
	}

}
