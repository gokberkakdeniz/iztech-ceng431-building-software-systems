package tr.edu.iztech.lol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import tr.edu.iztech.lol.model.AvailableChampions;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.services.IChampionSelectService;
import tr.edu.iztech.lol.view.IScreenManager;
import tr.edu.iztech.lol.view.screen.ChampionSelectPanel;

public class ChampionSelectController implements IChampionSelectController {
	private IScreenManager screenManager;
	private IChampionSelectService championSelectService;
	private ChampionSelectModel modelLeft;
	private ChampionSelectModel modelRight;
	private ChampionSelectPanel view;

	public ChampionSelectController(ChampionSelectPanel view, ChampionSelectModel modelLeft, ChampionSelectModel modelRight, IScreenManager screenManager, IChampionSelectService championSelectService) {
		this.view = view;
		this.modelLeft = modelLeft;
		this.modelRight = modelRight;
				
		this.championSelectService = championSelectService;
		this.screenManager = screenManager;
		
		this.view.addLeftChampionSelectPanelOriginButtonsListener(leftOriginButtonsListener);
		this.view.addRightChampionSelectPanelOriginButtonsListener(rightOriginButtonsListener);
		this.view.addLeftChampionSelectPanelHeroButtonsListener(leftHeroButtonsListener);
		this.view.addRightChampionSelectPanelHeroButtonsListener(rightHeroButtonsListener);
		
		modelLeft.subscribe(view);
		modelRight.subscribe(view);
	}
	
	private ActionListener leftOriginButtonsListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedOrigin = e.getActionCommand();
			modelLeft.setSelectedOrigin(selectedOrigin);
		}
	};
	
	private ActionListener rightOriginButtonsListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedOrigin = e.getActionCommand();
			modelRight.setSelectedOrigin(selectedOrigin);
		}
	};
	
	private ActionListener leftHeroButtonsListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedHero = e.getActionCommand();
			modelLeft.setSelectedHero(selectedHero);
		}
	};
	
	private ActionListener rightHeroButtonsListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedHero = e.getActionCommand();
			modelRight.setSelectedHero(selectedHero);
		}
	};
}
