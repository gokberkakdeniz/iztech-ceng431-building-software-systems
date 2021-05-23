package tr.edu.iztech.lol.app;

import java.util.Random;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.IState;
import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.utils.ThreadUtils;

public class TestSimulator {
	private int order = 0;
	private Match match;
	private Random random;
	
	public TestSimulator(Match match) {
		this.match = match;
		this.random = new Random();
	}
	
	public void run() {
    	reset();
		
		while (!match.isFinished()) {
			IHero attacker = getAttacker();
			IHero target = getTarget();
			
			User attackerUser = getAttackerUser();
			User targetUser = getTargetUser();

			IState damage = attacker.attack(target.getState());
			IState defendedDamage = target.defend(damage);

			target.setState(defendedDamage);
			match.notifySubscribers();
			
			match.addLog(String.format("%s deals %d damage to %s\n", attackerUser.getUsername(), defendedDamage.getDamageDealt(), targetUser.getUsername()));
	        
			waitRandomly();
			next();
		}
		IHero winner = match.getWinner();
		
		System.out.printf("\n Winner => %s\n", winner);
	}
			
	private void waitRandomly() {
		ThreadUtils.wait(1000 + random.nextInt(1500));
	}

	private IHero getAttacker() {
		return order == 0 ? match.getHeroLeft() : match.getHeroRight();
	}
	
	private IHero getTarget() {
		return order == 1 ? match.getHeroRight() : match.getHeroLeft();
	}
	
	private User getAttackerUser() {
		return order == 0 ? match.getUserLeft() : match.getUserRight();
	}
	
	private User getTargetUser() {
		return order == 1 ? match.getUserRight() : match.getUserLeft();
	}
	
	private void next() {
		order = (order + 1) % 2;
	}
	
	private void reset() {
		order = 0;
	}
}
