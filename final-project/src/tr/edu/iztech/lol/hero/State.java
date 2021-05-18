package tr.edu.iztech.lol.hero;

public class State implements IMutableState {
	private final int initialHealthPoint;
	private int healthPoint;
	private int attackDamage;
	private double criticalRatio;
	
	public State(int healthPoint, int attackDamage, double criticalRatio) {
		this.initialHealthPoint = healthPoint;
		this.healthPoint = healthPoint;
		this.attackDamage = attackDamage;
		this.criticalRatio = criticalRatio;
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
		return String.format("HP: %d, AD: %d, CR: %f", healthPoint, attackDamage, criticalRatio);
	}
	
	@Override
	public IState clone() {
		return new State(healthPoint, attackDamage, criticalRatio);
	}
}
