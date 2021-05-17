package tr.edu.iztech.lol.hero;

public interface IHero {
	IState attack(IState target);
	IState defend(IState damage);
	
	String getName();
	
	int getHealthPoint();
	
	// TODO: is it required?
	// void setHealtPoint(int healthPoint);
}
