package tr.edu.iztech.lol.view.screen;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.util.List;

import tr.edu.iztech.lol.model.Match;
import tr.edu.iztech.lol.view.component.ChampionFightComponent;

import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChampionFightPanel extends JPanel implements IChampionFightPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private Match model;
	private ChampionFightComponent fightLeft;
	private ChampionFightComponent figthRight;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	
	public ChampionFightPanel(Match model) {
		this.model = model;
		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator horizontalSeparator = new JSeparator();
		horizontalSeparator.setForeground(Color.DARK_GRAY);
		horizontalSeparator.setBounds(0, 430, 960, 1);
		add(horizontalSeparator);

		
		fightLeft = new ChampionFightComponent(model.getUserLeft(), model.getHeroLeft());
		fightLeft.setBounds(0,0, 480, 430);
		add(fightLeft);
		
		figthRight = new ChampionFightComponent(model.getUserRight(), model.getHeroRight(), true);
		figthRight.setBounds(480,0, 480, 430);
		add(figthRight);
		
//		JScrollPane listScroller = new JScrollPane();
//		listScroller.setBounds(10, 440, 940, 230);
//		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(-1);
//		listScroller.setViewportView(list);
        list.setBackground(new Color(0, 0, 0, 0));
        list.setBounds(10, 440, 940, 230);
		add(list);
		
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                repaint();
            }
        });

	}

	@Override
	public synchronized void update() {
		int previousSize = listModel.getSize();
		List<String> allLogs = model.getLogs();
		List<String> pendingLogs = allLogs.subList(previousSize, allLogs.size());
		listModel.addAll(pendingLogs);
		repaint();
		
		fightLeft.update();
		figthRight.update();
	}
}
