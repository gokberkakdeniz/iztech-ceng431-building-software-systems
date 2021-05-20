package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public class Eternal extends AbstractOrigin {
	private boolean isRevived = false;
	private double reviveMultiplier = 0.35;
	
	@Override
	public IState defend(IState damage) {
		IState tempDamage = damage.clone();
		
		if(willItDie(tempDamage) && !isRevived) {
			setRevived(true);
			revive(tempDamage);
		}
		
		return tempDamage;
	}
	
	private void revive(IState damage) {
		damage.setDamageDealt(0);
		
		int newHealth = (int) Math.floor(state.getInitialHealthPoint() * reviveMultiplier);
		state.setHealthPoint(newHealth);
	}
	
	private void setRevived(boolean value) {
		isRevived = value;
	}
	
	private boolean willItDie(IState damage) {
		int remainingHealth = damage.getDamageDealt() - state.getHealthPoint();
		return remainingHealth <= 0;
	}

}
