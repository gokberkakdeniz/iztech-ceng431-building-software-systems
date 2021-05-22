package tr.edu.iztech.lol.controller;

import java.util.List;

import tr.edu.iztech.lol.model.AvailableChampionsModel;
import tr.edu.iztech.lol.services.IChampionSelectService;
import tr.edu.iztech.lol.view.IScreenManager;

public class ChampionSelectController implements IChampionSelectController {
	private IScreenManager screenManager;
	private IChampionSelectService championSelectService;

	public ChampionSelectController(IScreenManager screenManager, IChampionSelectService championSelectService) {
		this.championSelectService = championSelectService;
		this.screenManager = screenManager;
	}
	
	public AvailableChampionsModel getModel() {
		return championSelectService.getAvailableChampions(4);
	}
}
