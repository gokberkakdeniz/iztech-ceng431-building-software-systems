package tr.edu.iztech.lol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.view.IScreenManager;
import tr.edu.iztech.lol.view.screen.IChampionSelectPanel;

public class ChampionSelectController implements IChampionSelectController {
	private IScreenManager screenManager;
	private ChampionSelectModel modelLeft;
	private ChampionSelectModel modelRight;
	private IChampionSelectPanel view;

	public ChampionSelectController(IChampionSelectPanel view, ChampionSelectModel modelLeft, ChampionSelectModel modelRight, IScreenManager screenManager) {
		this.view = view;
		this.modelLeft = modelLeft;
		this.modelRight = modelRight;
				
		this.screenManager = screenManager;
		
		this.view.addLeftChampionSelectPanelOriginButtonsListener(leftOriginButtonsListener);
		this.view.addRightChampionSelectPanelOriginButtonsListener(rightOriginButtonsListener);
		this.view.addLeftChampionSelectPanelHeroButtonsListener(leftHeroButtonsListener);
		this.view.addRightChampionSelectPanelHeroButtonsListener(rightHeroButtonsListener);
		this.view.addStartButtonListener(startButtonListener);
		
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
	
	private ActionListener startButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			screenManager.onChampionSelectDone(modelLeft, modelRight);
		}
	};

	@Override
	public void destroy() {
		modelLeft.unsubscribe(view);
		modelRight.unsubscribe(view);		
	}
}
