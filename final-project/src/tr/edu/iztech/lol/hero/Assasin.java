package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public class Assasin extends AbstractHero {
	public Assasin(IOrigin origin) {
		super(origin, new State(700, 120, 0.3));
		criticalMultiplier = 3;
	}	

}
