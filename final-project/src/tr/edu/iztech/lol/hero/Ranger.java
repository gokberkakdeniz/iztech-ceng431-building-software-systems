package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Ranger extends AbstractHero {
	private double criticalMultiplier = 1.3;
	
	public Ranger(IOrigin origin) {
		super(origin, new State(900, 60, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		tempTarget.setDamageDealt(state.getAttackDamage());
		
		multiplyCriticalRate();
		
		return tempTarget;
	}
	
	private void multiplyCriticalRate() {
		state.setCriticalRatio(state.getCriticalRatio()* criticalMultiplier);
	}


}
