package tr.edu.iztech.lol.factory;

import tr.edu.iztech.lol.hero.Assasin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.Demolitionist;
import tr.edu.iztech.lol.hero.GodKing;
import tr.edu.iztech.lol.hero.Knight;
import tr.edu.iztech.lol.hero.Ranger;
import tr.edu.iztech.lol.hero.Sorcerer;
import tr.edu.iztech.lol.origin.DragonSlayer;
import tr.edu.iztech.lol.origin.IOrigin;

public class DragonSlayerFactory implements IHeroFactory {

	@Override
	public Assasin createAssasin() {
		IOrigin origin = new DragonSlayer();
		Assasin hero = new Assasin(origin);

		return hero;
	}

	@Override
	public Cavalier createCavalier() {
		IOrigin origin = new DragonSlayer();
		Cavalier hero = new Cavalier(origin);

		return hero;
	}

	@Override
	public Demolitionist createDemolitionist() {
		IOrigin origin = new DragonSlayer();
		Demolitionist hero = new Demolitionist(origin);

		return hero;
	}

	@Override
	public GodKing createGodKing() {
		IOrigin origin = new DragonSlayer();
		GodKing hero = new GodKing(origin);

		return hero;
	}

	@Override
	public Knight createKnight() {
		IOrigin origin = new DragonSlayer();
		Knight hero = new Knight(origin);

		return hero;
	}

	@Override
	public Ranger createRanger() {
		IOrigin origin = new DragonSlayer();
		Ranger hero = new Ranger(origin);

		return hero;
	}

	@Override
	public Sorcerer createSorcerer() {
		IOrigin origin = new DragonSlayer();
		Sorcerer hero = new Sorcerer(origin);

		return hero;
	}

}
