package tr.edu.iztech.lol.origin;

import tr.edu.iztech.lol.hero.IState;
import java.util.Random;

public class DragonSlayer extends AbstractOrigin {
	private double executeChance = 0.02;

	@Override
	public IState attack(IState target) { 
		IState tempState = target.clone();
		int damage = tempState.getDamageDealt();
		
		if(shouldExecuteEnemy()) {
			damage = Integer.MAX_VALUE;
		} 

		tempState.setDamageDealt(damage);
		executeChance *= 1.4;
		
		return tempState;
	}

	private boolean shouldExecuteEnemy() {
        Random rand = new Random();
        
        return rand.nextDouble() <= executeChance;
	}

}
