package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;
import tr.edu.iztech.lol.utils.RandomUtils;

public class Knight extends AbstractHero {
	private double missChance = 0.05;

	public Knight(IOrigin origin) {
		super(origin, new State(1200, 90, 0.2));
	}

	@Override
	protected IState classDefence(IState damage) {
		IState tempDamage = damage.clone();

		if (isMissed()) {
			tempDamage.setDamageDealt(0);
		}
		multiplyMissChance();

		return tempDamage;
	}

	private void multiplyMissChance() {
		missChance *= 1.3;
	}
	
	private boolean isMissed() {
		return missChance >= RandomUtils.getDouble();
	}


}
