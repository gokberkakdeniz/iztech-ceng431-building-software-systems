package tr.edu.iztech.lol.services;

import java.util.List;

import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.TopWinnersModel;

public interface IStatisticsService {
	IResponse<MatchRecordsModel, NeverOccuredException> getMatchRecordsModel();
	IResponse<TopWinnersModel, NeverOccuredException> getTopWinnersModel();
	IResponse<List<MatchRecord>, NeverOccuredException> getMatchRecords(String username);
}
