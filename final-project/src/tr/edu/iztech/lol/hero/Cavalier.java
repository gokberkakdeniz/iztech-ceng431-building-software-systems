package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Cavalier extends AbstractHero {

	public Cavalier(IOrigin origin) {
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
