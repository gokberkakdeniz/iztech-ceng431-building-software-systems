package tr.edu.iztech.lol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.view.IScreenManager;
import tr.edu.iztech.lol.view.screen.IChampionFightPanel;

public class ChampionFightController implements IChampionFightController {
	private IScreenManager screenManager;
	private IChampionFightPanel view;
	private Match model;

	public ChampionFightController(IChampionFightPanel view, Match model, IScreenManager screenManager) {
		this.model = model;
		this.view = view;
		this.screenManager = screenManager;
		
		this.view.addStatisticsButtonListener(statisticsButtonListener);
		this.view.addLoginPageButtonListener(loginButtonListener);
		this.view.addPlayAgainButtonListener(playAgainButtonListener);
		model.subscribe(view);
	}
	
	@Override
	public void destroy() {
		model.unsubscribe(view);
	}

	private ActionListener statisticsButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			screenManager.onStatisticsPanelRequested();
		}
	};
	
	private ActionListener loginButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			screenManager.onLogoutRequested();
		}
	};
	
	private ActionListener playAgainButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			screenManager.onChampionSelectPanelRequested();
		}
	};
}
