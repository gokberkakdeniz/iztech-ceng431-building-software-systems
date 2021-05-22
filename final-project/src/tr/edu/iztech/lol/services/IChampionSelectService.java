package tr.edu.iztech.lol.services;

import java.util.List;

import tr.edu.iztech.lol.exception.NeverOccuredException;
import tr.edu.iztech.lol.model.AvailableChampionsModel;

public interface IChampionSelectService {
	IResponse<AvailableChampionsModel, NeverOccuredException> getAvailableChampions(int size);
}
