package tr.edu.iztech.lol.view.screen;

import java.awt.event.ActionListener;

public interface IChampionSelectPanel {
	void addLeftChampionSelectPanelOriginButtonsListener(ActionListener listener);
	void addLeftChampionSelectPanelHeroButtonsListener(ActionListener listener);
	void addRightChampionSelectPanelOriginButtonsListener(ActionListener listener);
	void addRightChampionSelectPanelHeroButtonsListener(ActionListener listener);
	void addStartButtonListener(ActionListener listener);
}
