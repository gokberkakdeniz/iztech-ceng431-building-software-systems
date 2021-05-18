package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public abstract class AbstractOrigin implements IOrigin {
	protected IState state;

	@Override
	public double getHealthPointMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAttackDamageMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCriticalRatioMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setState(IState state) {
		this.state = state;		
	}

}
