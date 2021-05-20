package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public interface IOrigin {
	IState defend(IState damage);
	IState attack(IState state);
	void setState(IState state);
}
