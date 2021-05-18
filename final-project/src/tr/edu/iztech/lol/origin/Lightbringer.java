package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public class Lightbringer extends AbstractOrigin {

	@Override
	public IState defend(IState damage) {
		IState tempDamage = damage.clone();
		
		if (shouldTakeLessDamage()) {
			int newDamage = tempDamage.getDamageDealt() / 2;
			tempDamage.setDamageDealt(newDamage);
		}
		return tempDamage;
	}
	
	private boolean shouldTakeLessDamage() {
		double healthPercentage = this.state.getHealthPoint() / this.state.getInitialHealthPoint();
		
		return healthPercentage <= 0.3;
	}

	@Override
	public IState attack(IState target) {
		// TODO Auto-generated method stub
		return null;
	}

}
