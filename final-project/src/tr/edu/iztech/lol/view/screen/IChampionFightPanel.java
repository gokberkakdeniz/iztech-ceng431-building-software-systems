package tr.edu.iztech.lol.view.screen;

import java.awt.event.ActionListener;

import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.utils.IObserver;

public interface IChampionFightPanel extends IObserver<Match> {

	void addStatisticsButtonListener(ActionListener statisticsButtonListener);

}
