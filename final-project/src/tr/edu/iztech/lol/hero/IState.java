package tr.edu.iztech.lol.hero;

public interface IState {
	int getAttackDamage();

	double getCriticalRatio();

	int getHealthPoint();
	
	IState clone();
}