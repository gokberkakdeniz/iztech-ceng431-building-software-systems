package tr.edu.iztech.lol.app;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.IState;
import tr.edu.iztech.lol.model.Match;

public class TestSimulator {
	private int order = 0;
	private Match match;
	
	public TestSimulator(Match match) {
		this.match = match;
	}
	
	public void run() {
		reset();
		
		while (!isFinished()) {
			IHero attacker = getAttacker();
			IHero target = getTarget();
			
			System.out.printf("> %s -----> %s\n", attacker.getName(), target.getName());
//			System.out.printf("  before attack => %s\n", target.getState());

			IState damage = attacker.attack(target.getState());
			IState defendedDamage = target.defend(damage);

			target.setState(defendedDamage);
//			System.out.printf("      after attack  => %s\n", damage);
//			System.out.printf("      after defence => %s\n", defendedDamage);
			System.out.printf("      %s => %s\n", defendedDamage, target.getState());
//	        Random rand = new Random();
//			ThreadUtils.wait(1000 + rand.nextInt(1500));
			next();
		}
		IHero winner = getWinner();
		
		System.out.printf("\n Winner => %s\n", winner);

	}
	
	private IHero getWinner() {
		if (!isFinished()) return null;
		
		return match.getHeroLeft().getHealthPoint() > 0 ? match.getHeroLeft() : match.getHeroRight();
	}
	
	private IHero getAttacker() {
		return order == 0 ? match.getHeroLeft() : match.getHeroRight();
	}
	
	private IHero getTarget() {
		return order == 1 ? match.getHeroRight() : match.getHeroLeft();
	}
	
	private void next() {
		order = (order + 1) % 2;
	}
	
	private void reset() {
		order = 0;
	}
	
	private boolean isFinished() {
		return match.getHeroLeft().getHealthPoint() <= 0 || match.getHeroRight().getHealthPoint() <= 0;
	}
}
