package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;
import tr.edu.iztech.lol.utils.StringUtils;

public abstract class AbstractHero implements IHero {
	protected IMutableState state;
	protected IOrigin origin;
	
	public AbstractHero(IOrigin origin, IMutableState state) {
		this.state = state;
		this.origin = origin;
		this.origin.setState(state);
	}
	
	public int getHealthPoint() {
		return state.getHealthPoint();
	}
	
	public void setHealtPoint(int healthPoint) {
		this.state.setHealthPoint(healthPoint);
	}
	
	public String getName() {
		String originName = StringUtils.humanizeCamelCase(origin.getClass().getSimpleName());
		String heroName = StringUtils.humanizeCamelCase(this.getClass().getSimpleName());
		
		return String.format("%s %s", originName, heroName);
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s)", getName(), state);
	}
	
	@Override
	public IState attack(IState target) {
		IState attackedByClass = classAttack(target);
		IState attackByOrigin = origin.attack(attackedByClass);
		return attackByOrigin;
	}
	
	@Override
	public IState defend(IState damage) {
		IState damageByClass = classDefence(damage);
		IState damageByOrigin = origin.defend(damageByClass);
		return damageByOrigin.clone();
	}
	
	abstract protected IState classAttack(IState target);
	abstract protected IState classDefence(IState damage);
}
