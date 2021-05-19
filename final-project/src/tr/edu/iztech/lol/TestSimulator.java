package tr.edu.iztech.lol;

import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.IState;

public class TestSimulator {
	private IHero hero1;
	private IHero hero2;
	private int order = 0;
	
	public TestSimulator(IHero hero1, IHero hero2) {
		this.hero1 = hero1;
		this.hero2 = hero2;
	}
	
	public void run() {
		reset();
		
		while (!isFinished()) {
			IHero attacker = getAttacker();
			IHero target = getTarget();
			
			System.out.printf("> %s -----> %s\n", attacker.getName(), target.getName());
			System.out.printf("  before attack => %s\n", target.getState());

			IState damage = attacker.attack(target.getState());
			IState defendedDamage = target.defend(damage);

			target.setState(defendedDamage);
			
			System.out.printf("  after attack  => %s\n", damage);
			System.out.printf("  after defence => %s\n", defendedDamage);
			System.out.printf("  after apply => %s\n", target.getState());

			
			next();
		}
	}
	
	private IHero getAttacker() {
		return order == 0 ? hero1 : hero2;
	}
	
	private IHero getTarget() {
		return order == 1 ? hero1 : hero2;
	}
	
	private void next() {
		order = (order + 1) % 2;
	}
	
	private void reset() {
		order = 0;
	}
	
	private boolean isFinished() {
		return hero1.getHealthPoint() == 0 || hero2.getHealthPoint() == 0;
	}
}
