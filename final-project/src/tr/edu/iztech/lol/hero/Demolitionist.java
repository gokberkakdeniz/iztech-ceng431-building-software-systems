package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Demolitionist extends AbstractHero {
	private int attackCount = 1;
	
	public Demolitionist(IOrigin origin) {
		super(origin, new State(1100, 70, 0.2));
	}

	@Override
	protected IState classAttack(IState target) {
		IState tempTarget = target.clone();
		int attackDamage = state.getAttackDamage();
		
		if(isThirdAttack()) {
			attackDamage *= 2;
		}
		
		tempTarget.setDamageDealt(attackDamage);
		
		attackCount++;
		return tempTarget;
	}

	private boolean isThirdAttack() {
		return attackCount % 3 == 0;
	}
}
