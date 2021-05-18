package tr.edu.iztech.lol.hero;

public interface IState {
	int getAttackDamage();

	double getCriticalRatio();

	int getInitialHealthPoint();
	
	int getHealthPoint();
	
	void setAttackDamage(int attackDamage);

	void setCriticalRatio(double criticalRatio);

	void setHealthPoint(int healthPoint);
	
	int getDamageDealt();
	
	void setDamageDealt(int damageDealt);
	
	IState clone();
}