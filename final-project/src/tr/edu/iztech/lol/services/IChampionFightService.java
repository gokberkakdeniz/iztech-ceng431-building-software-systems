package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.model.User;

public interface IChampionFightService {
	IResponse<Match, NeverOccuredException> createMatch(User userLeft, String heroNameLeft, String originNameLeft,
														User userRight, String heroNameRight, String originNameRight);
	
	void startMatch(Match match);
}
