package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Cavalier extends AbstractHero {
	private double parryPercentage = 0.2;
	
	public Cavalier(IOrigin origin) {
		super(origin, new State(1200, 85, 0.2));
	}

	@Override
	protected IState classDefence(IState damage) {
		IState tempDamage = damage.clone();
		int newDamageDealt = (int) Math.round(tempDamage.getDamageDealt() * (1 - parryPercentage));
		
		tempDamage.setDamageDealt(newDamageDealt);
		return tempDamage;
	}

}
