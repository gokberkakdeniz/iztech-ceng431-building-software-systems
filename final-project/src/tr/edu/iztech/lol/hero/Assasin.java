package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Assasin extends AbstractHero {
	public Assasin(IOrigin origin) {
		super(origin, new State(1000, 100, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		tempTarget.setDamageDealt(getState().getAttackDamage());
		
		return tempTarget;
	}

	@Override
	protected IState classDefence(IState damage) {
		return damage.clone();
	}
}
