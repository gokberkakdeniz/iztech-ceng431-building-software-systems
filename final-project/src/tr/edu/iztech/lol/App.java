package tr.edu.iztech.lol;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import tr.edu.iztech.lol.data.*;
import tr.edu.iztech.lol.factory.*;
import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.model.User;

public class App {
	public static void main(String[] args) {	
		User u = new User("blabla");
		u.addMatchRecord((long) 2);
		u.addMatchRecord((long) 323);
		u.addMatchRecord((long) 2123);
		User u2 = new User("flafla");
		u2.addMatchRecord((long) 142);
		u2.addMatchRecord((long) 34123);
		u2.addMatchRecord((long) 2211123);
		File f = new File("users.json");
		UserSaver m = new UserSaver(f);
		UserLoader m2 = new UserLoader(f);
		m.save(Arrays.asList(u, u2));
		List<User> users = m2.load();
		
		for(User user: users) {
			System.out.println(user.getMatchRecordIds().get(0));
			System.out.println(user.getMatchRecordIds().get(1));
			System.out.println(user.getMatchRecordIds().get(2));
		}
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
