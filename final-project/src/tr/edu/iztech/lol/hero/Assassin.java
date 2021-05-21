package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Assassin extends AbstractHero {
	public Assassin(IOrigin origin) {
		super(origin, new State(750, 120, 0.3));
		criticalDamage = 3;
	}	

}
