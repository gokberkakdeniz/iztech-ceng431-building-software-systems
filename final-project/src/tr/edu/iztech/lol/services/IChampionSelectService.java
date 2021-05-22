package tr.edu.iztech.lol.services;

import java.util.List;

import tr.edu.iztech.lol.model.AvailableChampionsModel;

public interface IChampionSelectService {
	AvailableChampionsModel getAvailableChampions(int size);
}
