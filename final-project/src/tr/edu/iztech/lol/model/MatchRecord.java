package tr.edu.iztech.lol.model;

public class MatchRecord implements IModel {
	private long id;
	private Player winner;
	private Player loser;
	private int attackCount;
	
	public MatchRecord(Player winner, Player loser, int attackCount) {
		this(System.currentTimeMillis(), winner, loser, attackCount);
	}
	
	public MatchRecord(long id, Player winner, Player loser, int attackCount) {
		this.id = id;
		this.winner = winner;
		this.loser = loser;
		this.attackCount = attackCount;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public Player getLoser() {
		return loser;
	}
	
	public int getAttackCount() {
		return attackCount;
	}
	
	public long getId() {
		return id;
	}
}
