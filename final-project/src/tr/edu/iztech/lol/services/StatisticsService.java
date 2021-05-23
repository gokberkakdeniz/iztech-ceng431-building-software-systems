package tr.edu.iztech.lol.services;

import java.util.List;

import tr.edu.iztech.lol.data.Database;
import tr.edu.iztech.lol.data.IRepository;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.TopWinnersModel;
import tr.edu.iztech.lol.model.User;


public class StatisticsService implements IStatisticsService{
	private IRepository<User> userRepository = Database.getInstance().getUserRepository();
	private IRepository<MatchRecord> matchRecordRepository = Database.getInstance().getMatchRecordRepository();

	public StatisticsService() {}
	
	public MatchRecordsModel getMatchRecordsModel() {
		MatchRecordsModel matchRecordsModel = new MatchRecordsModel();
		List<MatchRecord> records = matchRecordRepository.getAll();
		
		matchRecordsModel.setMatchRecords(records);
		
		return matchRecordsModel;
	}
	
	
	public TopWinnersModel getTopWinnersModel() {
		TopWinnersModel topWinnersModel = new TopWinnersModel();
		for(User user: userRepository.getAll()) {
			topWinnersModel.addWinner(user);
		}
		return topWinnersModel;
	}
	
	public List<MatchRecord> getMatchRecords(String username) {
		return matchRecordRepository.getAll(user -> username.equals(user.getWinner().getUsername()) ||
													username.equals(user.getLoser().getUsername()));

	}
	
	
}
