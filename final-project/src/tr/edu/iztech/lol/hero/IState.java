package tr.edu.iztech.lol.hero;

public interface IState {
	int getAttackDamage();

	double getCriticalChance();

	int getInitialHealthPoint();
	
	int getHealthPoint();
	
	void setAttackDamage(int attackDamage);

	void setCriticalChance(double criticalChance);

	void setHealthPoint(int healthPoint);
	
	int getDamageDealt();
	
	void setDamageDealt(int damageDealt);
	
	IState clone();
}