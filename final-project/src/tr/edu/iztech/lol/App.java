package tr.edu.iztech.lol;

import tr.edu.iztech.lol.data.*;
import tr.edu.iztech.lol.factory.*;
import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.model.User;

public class App {
	public static void main(String[] args) {	
		UserJsonSerizalizer k = new UserJsonSerizalizer();
		User u = new User("blabla");
		k.serizalize(u);
//		simulator();
		
	}
	
	private void simulator() {
//		IHeroFactory ds = new DragonSlayerFactory();
//		IHero h1 = ds.createAssassin();		
//
//		IHeroFactory lb = new LightbringerFactory();
//		IHero h2 = lb.createCavalier();
//		
//		IHeroFactory ds = new EternalFactory();
//		IHero h1 = ds.createGodKing();		
//
//		IHeroFactory lb = new NightbringerFactory();
//		IHero h2 = lb.createKnight();
		
//		IHeroFactory ds = new IroncladFactory();
//		IHero h1 = ds.createRanger();		
//
//		IHeroFactory lb = new ForgottenFactory();
//		IHero h2 = lb.createSorcerer();
//		
//		IHeroFactory ds = new IroncladFactory();
//		IHero h1 = ds.createDemolitionist();		
//
//		IHeroFactory lb = new TricksterFactory();
//		IHero h2 = lb.createGodKing();
		
//		TestSimulator s = new TestSimulator(h1, h2);
//		s.run();
	}
}
