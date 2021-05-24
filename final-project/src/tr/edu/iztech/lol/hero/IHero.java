package tr.edu.iztech.lol.hero;

public interface IHero {
	IState attack(IState target);
	IState defend(IState damage);
	
	IState getState();
	String getName();
	
	int getHealthPoint();
	int getHealthPercentage();
	
	void setState(IState newState);
}
