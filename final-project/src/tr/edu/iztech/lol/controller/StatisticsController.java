package tr.edu.iztech.lol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.TopWinnersModel;
import tr.edu.iztech.lol.services.IStatisticsService;
import tr.edu.iztech.lol.view.IScreenManager;
import tr.edu.iztech.lol.view.screen.IStatisticsPanel;

public class StatisticsController implements IStatisticsController {
	private IStatisticsPanel view;
	private TopWinnersModel topWinnersModel;
	private MatchRecordsModel matchRecordsModel;
	private IStatisticsService statisticsService;
	private IScreenManager screenManager;
	
	public StatisticsController(IStatisticsPanel view, TopWinnersModel topWinnersModel, MatchRecordsModel matchRecordsModel, 
								IStatisticsService statisticsService, IScreenManager screenManager) {
		this.screenManager = screenManager;
		this.topWinnersModel = topWinnersModel;
		this.matchRecordsModel = matchRecordsModel;
		this.statisticsService = statisticsService;
		this.view = view;
		
		this.view.getMatchRecordsComponent().addSearchButtonListener(searchButtonListener);
		this.view.addGoLoginButtonListener(goLoginButtonListener);
		topWinnersModel.subscribe(view.getTopWinnersComponent());
		matchRecordsModel.subscribe(view.getMatchRecordsComponent());
	}
	
	@Override
	public void destroy() {
		topWinnersModel.unsubscribe(view.getTopWinnersComponent());
		matchRecordsModel.unsubscribe(view.getMatchRecordsComponent());
	}
	
	private ActionListener searchButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = view.getMatchRecordsComponent().getUsernameInput();
			List<MatchRecord> records = statisticsService.getMatchRecords(username).getResult();
			matchRecordsModel.setMatchRecords(records);
		}
	};

	private ActionListener goLoginButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			screenManager.onLogoutRequested();
		}
	};

}
