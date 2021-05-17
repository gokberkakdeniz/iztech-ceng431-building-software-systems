package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public interface IOrigin {
	double getHealthPointMultiplier();
	double getAttackDamageMultiplier();
	double getCriticalRatioMultiplier();
	IState defend(IState damage);
	IState attack(IState state);
	void setState(IState state);
}
