package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Sorcerer extends AbstractHero {

	public Sorcerer(IOrigin origin) {
		super(origin, new State(1000, 100, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IState classDefence(IState damage) {
		// TODO Auto-generated method stub
		return null;
	}


}
