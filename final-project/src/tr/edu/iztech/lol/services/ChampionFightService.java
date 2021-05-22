package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.app.TestSimulator;
import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IRepository;
import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.factory.DragonSlayerFactory;
import tr.edu.iztech.lol.factory.EternalFactory;
import tr.edu.iztech.lol.factory.ForgottenFactory;
import tr.edu.iztech.lol.factory.IHeroFactory;
import tr.edu.iztech.lol.factory.IroncladFactory;
import tr.edu.iztech.lol.factory.LightbringerFactory;
import tr.edu.iztech.lol.factory.NightbringerFactory;
import tr.edu.iztech.lol.factory.TricksterFactory;
import tr.edu.iztech.lol.hero.Assassin;
import tr.edu.iztech.lol.hero.Cavalier;
import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.User;

public class ChampionFightService implements IChampionFightService {
	private IRepository<MatchRecord> matchRecordRepository = Database.getInstance().getMatchRecordRepository();

	public ChampionFightService() {
	}

	@Override
	public IResponse<Match, NeverOccuredException> createMatch(User userLeft, String heroNameLeft, String originNameLeft, 
															   User userRight, String heroNameRight, String originNameRight) {
		IHero heroLeft = createHero(originNameLeft, heroNameLeft);
		IHero heroRight= createHero(originNameRight, heroNameRight);
		
		Match match = new Match(userLeft, heroLeft, userRight, heroRight);
		
		return new Response<>(match);
	}
	
	public void startMatch(Match match) {
		TestSimulator simulator = new TestSimulator(match);
		simulator.run();
	}
	
	private IHero createHero(String originName, String heroName) {
		IHeroFactory factory = getHeroFactory(originName);
		IHero result;
	
		switch (heroName) {
			case "Assassin":
				result = factory.createAssassin();
				break;
			case "Cavalier":
				result = factory.createCavalier();
				break;
			case "Demolitionist":
				result = factory.createDemolitionist();
				break;
			case "GodKing":
				result = factory.createGodKing();
				break;
			case "Knight":
				result = factory.createKnight();
				break;
			case "Ranger":
				result = factory.createRanger();
				break;
			case "Sorcerer":
				result = factory.createSorcerer();
				break;
			default:
				result = null;
				break;
		}
		
		return result;
	}
	
	private IHeroFactory getHeroFactory(String originName) {
		IHeroFactory result;
		
		switch (originName) {
			case "DragonSlayer":
				result = new DragonSlayerFactory();
				break;
			case "Eternal":
				result = new EternalFactory();
				break;
			case "Forgotten":
				result = new ForgottenFactory();
				break;
			case "Ironclad":
				result = new IroncladFactory();
				break;
			case "Lightbringer":
				result = new LightbringerFactory();
				break;
			case "Nightbringer":
				result = new NightbringerFactory();
				break;
			case "Trickster":
				result = new TricksterFactory();
				break;
			default:
				result = null;
		}
		
		return result;
	}
	
}
