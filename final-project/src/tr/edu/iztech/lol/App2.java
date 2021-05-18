package tr.edu.iztech.lol;

import tr.edu.iztech.lol.factory.DragonSlayerFactory;
import tr.edu.iztech.lol.factory.IHeroFactory;
import tr.edu.iztech.lol.hero.IHero;

public class App2 {
	public static void main(String[] args) {
		IHeroFactory f = new DragonSlayerFactory();
		IHero h = f.createGodKing();
		System.out.println(h);
	}
}
