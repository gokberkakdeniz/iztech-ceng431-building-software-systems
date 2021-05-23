package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.TopWinnersModel;
import tr.edu.iztech.lol.view.component.MatchRecordsComponent;
import tr.edu.iztech.lol.view.component.TopWinnersComponent;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class StatisticsPanel extends JPanel implements IStatisticsPanel {
	private static final long serialVersionUID = 5232814325896059657L;
	private TopWinnersComponent topWinners;
	private MatchRecordsComponent matchRecords;
	private JButton goLoginButton;

	public StatisticsPanel(TopWinnersModel topWinnersModel, MatchRecordsModel matchRecordsModel) {
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		topWinners = new TopWinnersComponent(topWinnersModel);
		topWinners.setBounds(0, 0, 479, 550);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(480, 0, 1, 620);
		add(separator);
		
		matchRecords = new MatchRecordsComponent(matchRecordsModel);
		matchRecords.setBounds(480, 0, 479, 620);
		
		add(topWinners);
		add(matchRecords);		
		
		goLoginButton = new JButton("Go Login");
		goLoginButton.setBounds(400, 640, 160, 25);
		add(goLoginButton);
	}
	
	public TopWinnersComponent getTopWinnersComponent() {
		return topWinners;
	}

	public MatchRecordsComponent getMatchRecordsComponent() {
		return matchRecords;
	}
	
	@Override
	public void addGoLoginButtonListener(ActionListener listener) {
		goLoginButton.addActionListener(listener);
	}
}
