package tr.edu.iztech.lol.view.screen;

import tr.edu.iztech.lol.view.component.MatchRecordsComponent;
import tr.edu.iztech.lol.view.component.TopWinnersComponent;

public interface IStatisticsPanel {
	TopWinnersComponent getTopWinnersComponent();
	MatchRecordsComponent getMatchRecordsComponent();
}
