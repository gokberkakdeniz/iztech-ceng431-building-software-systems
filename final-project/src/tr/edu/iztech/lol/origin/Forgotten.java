package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public class Forgotten extends AbstractOrigin {
	private double damagePercentage = 0.08;
	
	@Override
	public IState attack(IState target) {
		IState tempTarget = target.clone();
		
		int damage = tempTarget.getDamageDealt();
		int percentageDamage = (int) Math.floor(tempTarget.getHealthPoint() * damagePercentage);
		
		tempTarget.setDamageDealt(damage + percentageDamage);
		return tempTarget;
	}
}
