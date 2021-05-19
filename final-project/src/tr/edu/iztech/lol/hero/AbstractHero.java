package tr.edu.iztech.lol.hero;

import tr.edu.iztech.lol.origin.IOrigin;
import tr.edu.iztech.lol.utils.StringUtils;

public abstract class AbstractHero implements IHero {
	protected IState state;
	protected IOrigin origin;
	
	public AbstractHero(IOrigin origin, IState state) {
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
	
	public IState getState() {
		return state.clone();
	}
	
	public void setState(IState newState) {
		IState tempState = newState.clone();
		
		int nextHp = tempState.getHealthPoint() - tempState.getDamageDealt();
		tempState.setHealthPoint(nextHp);

		tempState.setAttackDamage(0);
		
		this.state = tempState;
		this.origin.setState(tempState);
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s)", getName(), state);
	}
	
	@Override
	public IState attack(IState target) {
		IState tempState = target.clone();
		tempState.setDamageDealt(0);
		
		IState classDamage = classAttack(tempState);
		IState totalDamage = origin.attack(classDamage);
		
//		System.out.println(totalDamage.getDamageDealt());
		return totalDamage;
	}
	
	@Override
	public IState defend(IState damage) {
		IState tempDamage = damage.clone();

		IState classDefense = classDefence(tempDamage);
		IState originDefense = origin.defend(classDefense);
		
//		System.out.println(originDefense.getDamageDealt());
		return originDefense;
	}
	
	abstract protected IState classAttack(IState target);
	abstract protected IState classDefence(IState damage);
}
