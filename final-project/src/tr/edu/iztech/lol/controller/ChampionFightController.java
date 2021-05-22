package tr.edu.iztech.lol.controller;

import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.view.screen.IChampionFightPanel;

public class ChampionFightController implements IChampionFightController {

	private IChampionFightPanel view;
	private Match model;

	public ChampionFightController(IChampionFightPanel view, Match model) {
		this.model = model;
		this.view = view;
		
		model.subscribe(view);
	}
	
	@Override
	public void destroy() {
		model.unsubscribe(view);
	}

}
