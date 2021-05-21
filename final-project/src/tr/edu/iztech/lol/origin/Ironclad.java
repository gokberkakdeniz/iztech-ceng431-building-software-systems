package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;
import tr.edu.iztech.lol.utils.RandomUtils;

public class Ironclad extends AbstractOrigin {
	private double parryPercentage = 0.12;
	
	@Override
	public IState defend(IState damage) {
		IState tempDamage = damage.clone();
		int damageDealt = tempDamage.getDamageDealt();
		
		if(willParry()) {
			if(damageDealt > 1000) {
				damageDealt = 100;
			}
			tempDamage.setHealthPoint(tempDamage.getHealthPoint() + damageDealt);
			tempDamage.setDamageDealt(0);
		}
		return tempDamage;
	}
	
	private boolean willParry() {
		return parryPercentage >= RandomUtils.getDouble();
	}

}
