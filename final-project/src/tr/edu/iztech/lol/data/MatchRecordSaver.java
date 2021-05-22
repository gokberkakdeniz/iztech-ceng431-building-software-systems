package tr.edu.iztech.lol.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import tr.edu.iztech.lol.hero.IState;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.Player;
import tr.edu.iztech.lol.model.User;

public class MatchRecordSaver implements IDataSaver<MatchRecord> {
	private final File file;
	
	public MatchRecordSaver(File file) {
		this.file = file;
	}
	
	@Override
	public void save(List<MatchRecord> data) {
		JSONArray list = new JSONArray();

		JSONObject userObject;
		for(MatchRecord matchRecord: data) {
			userObject = serialize(matchRecord);
			list.put(userObject);
		}
		
		try {
			FileWriter myFile = new FileWriter(file);
			myFile.write(list.toString(2));
			myFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private JSONObject serialize(MatchRecord matchRecord) {
		JSONObject userObject = new JSONObject();
		
		userObject.put("id", matchRecord.getId());
		userObject.put("attackCount", matchRecord.getAttackCount());
		
		Player winner = matchRecord.getWinner();
		Player loser = matchRecord.getLoser();

		userObject.put("winner", playerSerializer(winner));
		userObject.put("loser", playerSerializer(loser));

		return userObject;
	}
	
	private JSONObject playerSerializer(Player player) {
		JSONObject playerObject = new JSONObject();

		playerObject.put("username", player.getUsername());
		playerObject.put("heroName", player.getHeroName());
		
		IState startStatistics = player.getStartStatistic();
		IState endStatistics = player.getEndStatistic();

		playerObject.put("startStatistics", statisticSerializer(startStatistics));
		playerObject.put("endStatistics", statisticSerializer(endStatistics));

		return playerObject;
	}

	private JSONObject statisticSerializer(IState statistic) {
		JSONObject statisticObject = new JSONObject();

		statisticObject.put("initialHealth", statistic.getInitialHealthPoint());
		statisticObject.put("healthPoint", statistic.getHealthPoint());
		statisticObject.put("attackDamage", statistic.getAttackDamage());
		statisticObject.put("criticalChance", statistic.getCriticalChance());
		
		return statisticObject;
	}
}
