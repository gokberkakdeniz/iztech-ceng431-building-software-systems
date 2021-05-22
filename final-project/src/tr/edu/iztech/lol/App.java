package tr.edu.iztech.lol;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import tr.edu.iztech.lol.data.*;
import tr.edu.iztech.lol.factory.*;
import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.model.*;

public class App {
	public static void main(String[] args) {	
//		testUserLS();
//		simulator();
//		testMatchRecordLS();
		
	}
	
	private static void testMatchRecordLS() {
		State s1 = new State(70, 50, 60, 70, 430);
		State s2 = new State(121, 10, 20, 30, 03);
		State s3 = new State(1231, 11, 12, 13, 01);
		State s4 = new State(21442, 9, 8, 7, 20);

		Player player1 = new Player("player1", "mundo", s1 ,s2);
		Player player2 = new Player("player2", "hakahiko", s3 ,s4);

		MatchRecord m = new MatchRecord(player1, player2, 3);
		
		State s5 = new State(1234, 123450, 605421, 720, 4230);
		State s6 = new State(1241, 120, 202, 310, 013);
		State s7 = new State(12431, 114, 123, 213, 201);
		State s8 = new State(21412342, 91, 81, 17, 220);

		Player player3 = new Player("player31", "asdfgasdfg", s5 ,s6);
		Player player4 = new Player("player43", "adgfsadfg", s8 ,s7);

		MatchRecord m2 = new MatchRecord(player3, player4, 31213);
		File f = new File("matchRecords.json");
		MatchRecordSaver ms = new MatchRecordSaver(f);
		MatchRecordLoader ml = new MatchRecordLoader(f);
		ms.save(Arrays.asList(m, m2));
		List<MatchRecord> matchRecords = ml.load();

		for(MatchRecord mr: matchRecords) {
			System.out.println(mr.getId());
			System.out.println(mr.getAttackCount());
			System.out.println(mr.getWinner().getHeroName());
			System.out.println(mr.getWinner().getUsername());
			System.out.println(mr.getWinner().getStartStatistic().getInitialHealthPoint());
			System.out.println(mr.getWinner().getStartStatistic().getHealthPoint());
			System.out.println(mr.getWinner().getStartStatistic().getAttackDamage());
			System.out.println(mr.getWinner().getStartStatistic().getCriticalChance());
			System.out.println(mr.getWinner().getEndStatistic().getInitialHealthPoint());
			System.out.println(mr.getWinner().getEndStatistic().getHealthPoint());
			System.out.println(mr.getWinner().getEndStatistic().getAttackDamage());
			System.out.println(mr.getWinner().getEndStatistic().getCriticalChance());
			System.out.println(mr.getLoser().getHeroName());
			System.out.println(mr.getLoser().getUsername());
			System.out.println(mr.getLoser().getStartStatistic().getInitialHealthPoint());
			System.out.println(mr.getLoser().getStartStatistic().getHealthPoint());
			System.out.println(mr.getLoser().getStartStatistic().getAttackDamage());
			System.out.println(mr.getLoser().getStartStatistic().getCriticalChance());
			System.out.println(mr.getLoser().getEndStatistic().getInitialHealthPoint());
			System.out.println(mr.getLoser().getEndStatistic().getHealthPoint());
			System.out.println(mr.getLoser().getEndStatistic().getAttackDamage());
			System.out.println(mr.getLoser().getEndStatistic().getCriticalChance());

		}
	}
	
	private static void testUserLS() {
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
