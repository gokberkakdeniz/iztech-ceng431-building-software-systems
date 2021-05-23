package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import tr.edu.iztech.lol.hero.IState;
import tr.edu.iztech.lol.model.MatchRecord;
import tr.edu.iztech.lol.model.MatchRecordsModel;
import tr.edu.iztech.lol.model.Player;
import tr.edu.iztech.lol.utils.IObserver;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MatchRecordsComponent extends JPanel implements IObserver<MatchRecordsModel>{
	private static final long serialVersionUID = 5232858854896059657L;
	private MatchRecordsModel model;
	private final JLabel usernameLabel;
	private final JTextField usernameInput;
	private JButton searchButton;
	private JList<String> matchRecordsList;
	
	public MatchRecordsComponent(MatchRecordsModel model) {
		this.model = model;
		
		setLayout(null);
		setBounds(480,1,479,620);

		JLabel lblTopWinners = new JLabel("Match History");
		lblTopWinners.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopWinners.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblTopWinners.setBounds(0, 20, 480, 25);
		add(lblTopWinners);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(40, 70, 100, 25);
		add(usernameLabel);
		
		usernameInput = new JTextField();		
		usernameInput.setColumns(10);
		usernameInput.setBounds(130, 70, 200, 25);
		add(usernameInput);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(345, 70, 98, 25);
		add(searchButton);
		
		JScrollPane listScroller = new JScrollPane();
		listScroller.setBounds(10, 120, 460, 495);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		matchRecordsList = new JList<>();
		matchRecordsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		matchRecordsList.setVisibleRowCount(-1);
		matchRecordsList.setFixedCellHeight(90);
		matchRecordsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		matchRecordsList.setSelectionBackground(getBackground());
		matchRecordsList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				repaint();
			}
		});
		
		listScroller.setViewportView(matchRecordsList);
		add(listScroller);
			
	}
	
	public void update() {
		matchRecordsList.setListData(getMatchRecordsListData());
	}
	
	public void addSearchButtonListener(ActionListener listener) {
		searchButton.addActionListener(listener);
	}
	
	public String getUsernameInput() {
		return usernameInput.getText();
	}
	
	private String[] getMatchRecordsListData() {
		List<String> recordsString = new ArrayList<>();

		for(MatchRecord record: model.getMatchRecords()) {
			Player winner = record.getWinner();
			Player loser = record.getLoser();
			
			String winnerUsername = winner.getUsername();
			String loserUsername = loser.getUsername();

			String winnerHeroName = winner.getHeroName();
			IState winnerEndStatistics = winner.getEndStatistic();
			
			String loserHeroName = loser.getHeroName();
			IState loserEndStatistics = loser.getEndStatistic();
			
			
			recordsString.add(String.format("<html><li>%s WON against %s<br />Winner stats: %s<br />End: %s<br />"
					+ "Loser stats: %s<br/>End: %s", winnerUsername, loserUsername, winnerHeroName, 
					winnerEndStatistics, loserHeroName, loserEndStatistics));
		}
		return recordsString.toArray(String[]::new);
	}

}
