package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public abstract class AbstractOrigin implements IOrigin {
	protected IState state;
	
	@Override
	public IState attack(IState target) {
		return target.clone();
	}

	@Override
	public IState defend(IState damage) {
		return damage.clone();
	}
	
	@Override
	public void setState(IState state) {
		this.state = state;		
	}

}
