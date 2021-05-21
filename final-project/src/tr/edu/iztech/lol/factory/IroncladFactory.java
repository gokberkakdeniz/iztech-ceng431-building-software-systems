package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.origin.IOrigin;
import tr.edu.iztech.lol.origin.Ironclad;

public class IroncladFactory implements IHeroFactory {

	@Override
	public Assassin createAssassin() {
		IOrigin origin = new Ironclad();
		Assassin hero = new Assassin(origin);

		return hero;
	}

	@Override
	public Cavalier createCavalier() {
		IOrigin origin = new Ironclad();
		Cavalier hero = new Cavalier(origin);

		return hero;
	}

	@Override
	public Demolitionist createDemolitionist() {
		IOrigin origin = new Ironclad();
		Demolitionist hero = new Demolitionist(origin);

		return hero;
	}

	@Override
	public GodKing createGodKing() {
		IOrigin origin = new Ironclad();
		GodKing hero = new GodKing(origin);

		return hero;
	}

	@Override
	public Knight createKnight() {
		IOrigin origin = new Ironclad();
		Knight hero = new Knight(origin);

		return hero;
	}

	@Override
	public Ranger createRanger() {
		IOrigin origin = new Ironclad();
		Ranger hero = new Ranger(origin);

		return hero;
	}

	@Override
	public Sorcerer createSorcerer() {
		IOrigin origin = new Ironclad();
		Sorcerer hero = new Sorcerer(origin);

		return hero;
	}

}
