package tr.edu.iztech.lol.services;

import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.User;

public interface IChampionSelectService {
	IResponse<ChampionSelectModel, NeverOccuredException> getAvailableChampions(User user);
}
