package tr.edu.iztech.lol.services;

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
import tr.edu.iztech.lol.hero.IHero;
import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.Player;
import tr.edu.iztech.lol.model.User;

public class ChampionFightService implements IChampionFightService {
	private IRepository<MatchRecord> matchRecordRepository;

	public ChampionFightService(IRepository<MatchRecord> matchRecordRepository) {
		this.matchRecordRepository = matchRecordRepository;
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
		Runnable r = new Runnable() {
			public void run() {
				IFightSimulator simulator = new FightSimulator(match);
				simulator.run();
				createMatchRecord(match);
			}
		};
		
		(new Thread(r)).start();
	}
	
	private void createMatchRecord(Match match) {
		User winnerUser = match.getWinnerUser();
		IHero winnerHero = match.getWinner();
		User loserUser = match.getLoserUser();
		IHero loserHero = match.getLoser();
		
		Player winner = new Player(winnerUser.getUsername(), winnerHero.getName(), winnerHero.getState());
		Player loser = new Player(loserUser.getUsername(), loserHero.getName(), loserHero.getState());
		
		MatchRecord record = new MatchRecord(winner, loser, match.getLogs().size()/2);
		matchRecordRepository.add(record);
		winnerUser.addMatchRecord(record.getId());
		winnerUser.increaseWinCount();
		loserUser.addMatchRecord(record.getId());
		loserUser.increaseLoseCount();
		Database.getInstance().save();
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
