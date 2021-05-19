package tr.edu.iztech.lol.hero;

public class State implements IState {
	private int initialHealthPoint;
	private int healthPoint;
	private int attackDamage;
	private int damageDealt;
	private double criticalRatio;
		
	public State(int healthPoint, int attackDamage, double criticalRatio) {
		this.initialHealthPoint = healthPoint;
		this.healthPoint = healthPoint;
		this.attackDamage = attackDamage;
		this.criticalRatio = criticalRatio;
		this.damageDealt = 0;
	}
	
	private State(int initialHealthPoint, int healthPoint, int attackDamage, double criticalRatio, int damageDealt) {
		this(healthPoint, attackDamage, criticalRatio);
		this.initialHealthPoint = initialHealthPoint;
		this.damageDealt = damageDealt;
	}

	
	public int getDamageDealt() {
		return damageDealt;
	}
	
	public void setDamageDealt(int damageDealt) {
		this.damageDealt = damageDealt;
	}
	
	@Override
	public int getAttackDamage() {
		return attackDamage;
	}
	
	@Override
	public double getCriticalRatio() {
		return criticalRatio;
	}
	
	@Override
	public int getInitialHealthPoint() {
		return initialHealthPoint;
	}
	
	@Override
	public int getHealthPoint() {
		return healthPoint;
	}
	
	@Override
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	
	@Override
	public void setCriticalRatio(double criticalRatio) {
		this.criticalRatio = criticalRatio;
	}
	
	@Override
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}
	
	@Override
	public String toString() {
		return String.format("HP: %d, AD: %d, CR: %d%%", healthPoint, attackDamage, Math.round(criticalRatio*100));
	}
	
	@Override
	public IState clone() {
		return new State(initialHealthPoint, healthPoint, attackDamage, criticalRatio, damageDealt);
	}
}
