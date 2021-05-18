package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;
import java.util.Random;

public class DragonSlayer implements IOrigin {
	private IState state;
	private double executeChance = 0.02;
	
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
	public IState defend(IState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IState attack(IState state) { 
		IState tempState = state.clone();
     
		if(shouldExecuteEnemy()) {
			tempState.setDamageDealt(Integer.MAX_VALUE);
		} else {
			executeChance *= 1.4;
			tempState.setDamageDealt(this.state.getAttackDamage());
		}
		
		return tempState;
	}

	private boolean shouldExecuteEnemy() {
        Random rand = new Random();
        
        return rand.nextDouble() <= executeChance;
	}
	
	@Override
	public void setState(IState state) {
		this.state = state;		
	}

}
