package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class GodKing extends AbstractHero {
	private double executePercentage = 0.25;
	
	public GodKing(IOrigin origin) {
		super(origin, new State(1200, 90, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		int damage = state.getAttackDamage();
		
		if(willBeExecuted(tempTarget)) {
			damage = Integer.MAX_VALUE;
		}
		
		tempTarget.setDamageDealt(damage);
		return tempTarget;
	}
	
	private boolean willBeExecuted(IState target) {
		double healthPercentage = (double) target.getHealthPoint() / target.getInitialHealthPoint();
		return healthPercentage <= executePercentage;
	}

}
