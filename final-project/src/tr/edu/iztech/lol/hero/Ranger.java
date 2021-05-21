package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Ranger extends AbstractHero {
	private double criticalRateMultiplier = 1.4;
	
	public Ranger(IOrigin origin) {
		super(origin, new State(900, 65, 0.2));
		criticalDamage = 2;
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		tempTarget.setDamageDealt(state.getAttackDamage());

		if(state.getCriticalChance() >= 1) {
			this.criticalDamage *= 1.15;
		} else {
			multiplyCriticalRate();
		}
		
		return tempTarget;
	}
	
	private void multiplyCriticalRate() {
		state.setCriticalChance(state.getCriticalChance()* criticalRateMultiplier);
	}


}
