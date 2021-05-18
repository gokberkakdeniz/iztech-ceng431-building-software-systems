package tr.edu.iztech.lol;

import tr.edu.iztech.lol.factory.*;
import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.hero.IState;

public class App2 {
	public static void main(String[] args) {
//		IHeroFactory f = new DragonSlayerFactory();
//		IHero h = f.createGodKing();
		
		IHeroFactory ds = new DragonSlayerFactory();
		IHero dsas = ds.createAssasin();
		
		IHeroFactory lb = new LightbringerFactory();
		IHero lbca = lb.createCavalier();
		
		System.out.println(lbca);

		IState m = dsas.attack(lbca.getState());
		IState g = lbca.defend(m);
		g.setHealthPoint(g.getHealthPoint() - g.getDamageDealt());
		g.setDamageDealt(0);
		lbca.setState(g);
				
		System.out.println(lbca);
		
	}
}
