package tr.edu.iztech.lol.services;

import java.util.List;

import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.model.AvailableChampions;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.User;

public interface IChampionSelectService {
	IResponse<ChampionSelectModel, NeverOccuredException> getAvailableChampions(User user);
}
