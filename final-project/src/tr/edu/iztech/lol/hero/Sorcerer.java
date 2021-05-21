package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Sorcerer extends AbstractHero {
	private double attackDamageStealPercentage = 0.05;
	
	public Sorcerer(IOrigin origin) {
		super(origin, new State(1100, 90, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		tempTarget.setDamageDealt(state.getAttackDamage());
		
		stealAttackDamage(tempTarget);
		
		return tempTarget;
	}

	private void stealAttackDamage(IState target) {
		int stealedAD = (int) Math.floor(target.getAttackDamage() * attackDamageStealPercentage);
		
		target.setAttackDamage(target.getAttackDamage() - stealedAD);
		state.setAttackDamage(state.getAttackDamage() + stealedAD);
	}

}
