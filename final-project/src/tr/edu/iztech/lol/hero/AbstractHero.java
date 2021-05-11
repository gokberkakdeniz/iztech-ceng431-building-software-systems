package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;

public abstract class AbstractHero implements IHero {
	protected int healthPoint;
	protected int attackDamage;
	protected double criticalRatio;
	
	public AbstractHero(IOrigin origin, int healthPoint, int attackDamage, double criticalRatio) {
		this.healthPoint = (int) (origin.getHealthPointMultiplier() * healthPoint);
		this.attackDamage = (int) (origin.getAttackDamageMultiplier() * attackDamage);
		this.criticalRatio = (int) (origin.getCriticalRatioMultiplier() * criticalRatio);
	}
	
	public int getHealthPoint() {
		return healthPoint;
	}
	
	public void setHealtPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}
}
