package tr.edu.iztech.lol.view.screen;

import java.awt.event.ActionListener;

import tr.edu.iztech.lol.view.component.MatchRecordsComponent;
import tr.edu.iztech.lol.view.component.TopWinnersComponent;

public interface IStatisticsPanel {
	TopWinnersComponent getTopWinnersComponent();
	MatchRecordsComponent getMatchRecordsComponent();
	void addGoLoginButtonListener(ActionListener listener);
}
