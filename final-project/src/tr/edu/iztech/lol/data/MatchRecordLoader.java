package tr.edu.iztech.lol.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import tr.edu.iztech.lol.hero.State;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.Player;

public class MatchRecordLoader implements IDataLoader<MatchRecord> {
	private final File file;
	
	public MatchRecordLoader(File file) {
		this.file = file;
	}
	
	@Override
	public List<MatchRecord> load() {
		InputStream is = null;
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONTokener tokener = new JSONTokener(is);
        JSONArray jsonArray = new JSONArray(tokener);
        
		List<MatchRecord> matchRecords = new ArrayList<>();

		for(Object obj: jsonArray) {
			matchRecords.add(deserialize((JSONObject) obj));
		}
		
		return matchRecords;
	}
	
	private MatchRecord deserialize(JSONObject matchRecord) {		
		long id = matchRecord.getLong("id");
		int attackCount = matchRecord.getInt("attackCount");
		
		JSONObject winnerField = matchRecord.getJSONObject("winner");
		JSONObject loserField = matchRecord.getJSONObject("loser");

		Player winner = playerDeserializer(winnerField);
		Player loser = playerDeserializer(loserField);

		return new MatchRecord(id, winner, loser, attackCount);
	}
	
	private Player playerDeserializer(JSONObject playerField) {
		String username = playerField.getString("username");
		String heroName = playerField.getString("heroName");

		JSONObject endStatisticField = playerField.getJSONObject("endStatistics");
		
		State endStatistic = statisticDeserializer(endStatisticField);
		
		return new Player(username, heroName, endStatistic);
	}

	private State statisticDeserializer(JSONObject statisticField) {
		int initialHealthPoint = statisticField.getInt("initialHealth");
		int healthPoint = statisticField.getInt("healthPoint");
		int attackDamage = statisticField.getInt("attackDamage");
		double criticalChance = statisticField.getDouble("criticalChance");
		
		return new State(initialHealthPoint, healthPoint, attackDamage, criticalChance, 0);
	}
}
