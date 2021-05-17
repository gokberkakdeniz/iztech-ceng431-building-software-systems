package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;

public class Ironclad implements IOrigin {
	private IState state;

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
	public IState defend(IState damage) {
		return damage.clone();		
	}

	@Override
	public IState attack(IState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setState(IState state) {
		// TODO Auto-generated method stub
		
	}
}
