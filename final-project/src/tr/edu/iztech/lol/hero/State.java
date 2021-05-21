package tr.edu.iztech.lol.hero;

public class State implements IState {
	private int initialHealthPoint;
	private int healthPoint;
	private int attackDamage;
	private int damageDealt;
	private double criticalChance;
		
	public State(int healthPoint, int attackDamage, double criticalChance) {
		this.initialHealthPoint = healthPoint;
		this.healthPoint = healthPoint;
		this.attackDamage = attackDamage;
		this.criticalChance = criticalChance;
		this.damageDealt = 0;
	}
	
	private State(int initialHealthPoint, int healthPoint, int attackDamage, double criticalChance, int damageDealt) {
		this(healthPoint, attackDamage, criticalChance);
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
	public double getCriticalChance() {
		return criticalChance;
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
	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}
	
	@Override
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}
	
	@Override
	public String toString() {
		return String.format("HP: %d, AD: %d, CR: %d%%", healthPoint, attackDamage, Math.round(criticalChance*100));
	}
	
	@Override
	public IState clone() {
		return new State(initialHealthPoint, healthPoint, attackDamage, criticalChance, damageDealt);
	}
}
