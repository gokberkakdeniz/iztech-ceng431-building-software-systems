package tr.edu.iztech.lol.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.data.IRepository;
import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.TopWinnersModel;
import tr.edu.iztech.lol.model.User;


public class StatisticsService implements IStatisticsService {
	private IRepository<User> userRepository;
	private IRepository<MatchRecord> matchRecordRepository;

	public StatisticsService(IRepository<User> userRepository, IRepository<MatchRecord> matchRecordRepository) {
		this.matchRecordRepository = matchRecordRepository;
		this.userRepository = userRepository;
	}
	
	public IResponse<MatchRecordsModel, NeverOccuredException> getMatchRecordsModel() {
		MatchRecordsModel matchRecordsModel = new MatchRecordsModel();
		List<MatchRecord> records = matchRecordRepository.getAll();
		
		matchRecordsModel.setMatchRecords(records);
		
		return new Response<>(matchRecordsModel);
	}
	
	
	public IResponse<TopWinnersModel, NeverOccuredException> getTopWinnersModel() {
		List<User> users = userRepository.getAll().stream()
								.sorted(Comparator.comparing(User::getWinRate).reversed())
								.collect(Collectors.toList());
		List<User> topWinners = users.subList(0, Math.min(10, users.size()));
		
		return new Response<>(new TopWinnersModel(topWinners));
	}
	
	public IResponse<List<MatchRecord>, NeverOccuredException>  getMatchRecords(String username) {
		return new Response<>(matchRecordRepository
								.getAll(user -> username.equals(user.getWinner().getUsername()) ||
												username.equals(user.getLoser().getUsername()))
								.stream()
								.sorted(Comparator.comparing(MatchRecord::getId).reversed())
								.collect(Collectors.toList()));
	}
	
	
}
