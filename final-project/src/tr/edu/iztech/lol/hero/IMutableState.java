package tr.edu.iztech.lol.hero;

public interface IMutableState extends IState {
	void setAttackDamage(int attackDamage);

	void setCriticalRatio(double criticalRatio);

	void setHealthPoint(int healthPoint);
}
