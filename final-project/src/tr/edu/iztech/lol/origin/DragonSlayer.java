package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;
import java.util.Random;

public class DragonSlayer extends AbstractOrigin {
	private double executeChance = 0.02;

	@Override
	public IState defend(IState damage) {
		return damage.clone();
	}

	@Override
	public IState attack(IState target) { 
		IState tempState = target.clone();
     
		if(shouldExecuteEnemy()) {
			tempState.setDamageDealt(Integer.MAX_VALUE);
		} else {
			executeChance *= 1.4;
			tempState.setDamageDealt(getState().getAttackDamage());
		}
		
		return tempState;
	}

	private boolean shouldExecuteEnemy() {
        Random rand = new Random();
        
        return rand.nextDouble() <= executeChance;
	}

}
