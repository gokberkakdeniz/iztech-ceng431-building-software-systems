package tr.edu.iztech.lol;

import tr.edu.iztech.lol.factory.*;
import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.view.MainWindow;

public class App {
	public static void main(String[] args) {
		// new MainWindow();
		
		IHeroFactory ds = new DragonSlayerFactory();
		IHeroFactory lb = new LightbringerFactory();
	
		IHero h1 = ds.createAssasin();		
		IHero h2 = lb.createCavalier();
		
		TestSimulator s = new TestSimulator(h1, h2);
		s.run();
	}
}
