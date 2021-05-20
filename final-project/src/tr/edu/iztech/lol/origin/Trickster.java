package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;
import tr.edu.iztech.lol.utils.RandomUtils;

public class Trickster extends AbstractOrigin {	
	private double luckMultiplier = 0.5;
	
	@Override
	public IState attack(IState target) {
		IState tempTarget = target.clone();
		int attackDamage = state.getAttackDamage();
		int damageDealt = tempTarget.getDamageDealt();
		
		if(isGetLucky()) {
			tempTarget.setDamageDealt(damageDealt + attackDamage);
		} else {
			state.setHealthPoint(state.getHealthPoint() - attackDamage);
		}

		return tempTarget;
	}
	
	private boolean isGetLucky() {
		return luckMultiplier >= RandomUtils.getDouble();
	}
}
