package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Cavalier extends AbstractHero {
	private double parryPercentage = 0.2;
	
	public Cavalier(IOrigin origin) {
		super(origin, new State(1000, 100, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		tempTarget.setDamageDealt(this.state.getAttackDamage());
		
		return tempTarget;
	}

	@Override
	protected IState classDefence(IState damage) {
		IState tempDamage = damage.clone();
		int newDamageDealt = (int) Math.round(tempDamage.getDamageDealt() * (1 - parryPercentage));
		
		tempDamage.setDamageDealt(newDamageDealt);
		return tempDamage;
	}

}
