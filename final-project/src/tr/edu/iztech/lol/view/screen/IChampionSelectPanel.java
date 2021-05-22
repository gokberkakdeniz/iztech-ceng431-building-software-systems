package tr.edu.iztech.lol.view.screen;

import java.awt.event.ActionListener;

import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.utils.IObserver;

public interface IChampionSelectPanel extends IObserver<ChampionSelectModel> {
	void addLeftChampionSelectPanelOriginButtonsListener(ActionListener listener);
	void addLeftChampionSelectPanelHeroButtonsListener(ActionListener listener);
	void addRightChampionSelectPanelOriginButtonsListener(ActionListener listener);
	void addRightChampionSelectPanelHeroButtonsListener(ActionListener listener);
	void addStartButtonListener(ActionListener listener);
}
