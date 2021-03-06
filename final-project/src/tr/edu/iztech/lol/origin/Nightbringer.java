package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public class Nightbringer extends AbstractOrigin {
	private double healthPercentage = 0.35;
	
	@Override
	public IState attack(IState target) {
		IState tempTarget = target.clone();
		
		if(isBelowHealth()) {
			tempTarget.setDamageDealt(tempTarget.getDamageDealt() * 2);
		}
		
		return tempTarget;
	}
	
	private boolean isBelowHealth() {
		double currentHealth = (double) state.getHealthPoint() / state.getInitialHealthPoint();
		return currentHealth <= healthPercentage;
	}

}
