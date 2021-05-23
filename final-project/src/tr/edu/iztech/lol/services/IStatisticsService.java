package tr.edu.iztech.lol.services;

import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.TopWinnersModel;

public interface IStatisticsService {
	MatchRecordsModel getMatchRecordsModel();
	TopWinnersModel getTopWinnersModel();
	List<MatchRecord> getMatchRecords(String username);
}
