package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingConstants;

import tr.edu.iztech.lol.controller.IChampionSelectController;
import tr.edu.iztech.lol.model.AvailableChampions;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.utils.IObserver;
import tr.edu.iztech.lol.view.component.ChampionSelectComponent;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChampionSelectPanel extends JPanel implements IChampionSelectPanel, IObserver<ChampionSelectModel> {
	private static final long serialVersionUID = 5232858854896059657L;
	private ChampionSelectComponent left;
	private ChampionSelectComponent right;
	private JButton startButton;
	
	public ChampionSelectPanel(ChampionSelectModel modelLeft, ChampionSelectModel modelRight) {
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		startButton = new JButton("Start");
		startButton.setBounds(331, 585, 300, 47);
		add(startButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(480, 0, 1, 550);
		add(separator);
		
		left = new ChampionSelectComponent(modelLeft);
		left.setBounds(0,0, 480, 720);
		add(left);
		
		right = new ChampionSelectComponent(modelRight);
		right.setBounds(480,0, 480, 720);		
		add(right);
	}

	@Override
	public void addLeftChampionSelectPanelOriginButtonsListener(ActionListener listener) {
		left.addOriginButtonsListener(listener);		
	}

	@Override
	public void addLeftChampionSelectPanelHeroButtonsListener(ActionListener listener) {
		left.addHeroButtonsListener(listener);
	}

	@Override
	public void addRightChampionSelectPanelOriginButtonsListener(ActionListener listener) {
		right.addOriginButtonsListener(listener);
	}

	@Override
	public void addRightChampionSelectPanelHeroButtonsListener(ActionListener listener) {
		right.addHeroButtonsListener(listener);
	}
	
	public void addStartButtonListener(ActionListener listener) {
		startButton.addActionListener(listener);
	}

	@Override
	public void update() {
		left.update();
		right.update();
	}
	
}
