package tr.edu.iztech.lol.view.screen;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.view.component.ChampionFightComponent;

import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class ChampionFightPanel extends JPanel implements IChampionFightPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private Match model;
	private ChampionFightComponent fightLeft;
	private ChampionFightComponent figthRight;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JButton statisticsButton;
	private JLabel lblUsername;
	private JPanel panel;
	
	public ChampionFightPanel(Match model) {
		this.model = model;
		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator horizontalSeparator = new JSeparator();
		horizontalSeparator.setForeground(Color.DARK_GRAY);
		horizontalSeparator.setBounds(0, 430, 960, 1);
		add(horizontalSeparator);

		fightLeft = new ChampionFightComponent(model.getUserLeft(), model.getHeroLeft());
		fightLeft.setBounds(0,0, 480, 237);
		add(fightLeft);
		
		figthRight = new ChampionFightComponent(model.getUserRight(), model.getHeroRight(), true);
		figthRight.setBounds(480,0, 480, 237);
		add(figthRight);
		
		JScrollPane listScroller = new JScrollPane();
		listScroller.setBounds(10, 440, 940, 230);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        list.setEnabled(false);
        list.setVisibleRowCount(-1);
		listScroller.setViewportView(list);
		add(listScroller);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(220, 270, 440, 120);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblWinner = new JLabel("WINNER!");
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinner.setBounds(0, 3, 440, 40);
		panel.add(lblWinner);
		lblWinner.setFont(new Font("Dialog", Font.BOLD, 34));
		lblWinner.setAlignmentX(Component.CENTER_ALIGNMENT);

		lblUsername = new JLabel();
		lblUsername.setBounds(0, 42, 440, 29);
		panel.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 24));
		
		statisticsButton = new JButton("Statistics");
		statisticsButton.setBounds(300, 85, 120, 25);
		panel.add(statisticsButton);
		
		JButton btnLoginPage = new JButton("Login Page");
		btnLoginPage.setBounds(20, 85, 120, 25);
		panel.add(btnLoginPage);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(160, 85, 115, 25);
		panel.add(btnPlayAgain);
}

	@Override
	public synchronized void update() {
		int previousSize = listModel.getSize();
		List<String> allLogs = model.getLogs();
		List<String> pendingLogs = allLogs.subList(previousSize, allLogs.size());
		listModel.addAll(pendingLogs);
		
		fightLeft.update();
		figthRight.update();
		
		if (model.isFinished()) {
			lblUsername.setText(model.getWinnerUser().getUsername());
			panel.setVisible(true);
		}
	}
	

	public void addStatisticsButtonListener(ActionListener listener) {
		statisticsButton.addActionListener(listener);
	}}
