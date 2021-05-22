package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.List;

import javax.swing.SwingConstants;

import tr.edu.iztech.lol.controller.IChampionSelectController;
import tr.edu.iztech.lol.model.AvailableChampionsModel;
import tr.edu.iztech.lol.model.Session;
import tr.edu.iztech.lol.view.component.ChampionSelectComponent;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChampionSelectPanel extends JPanel implements IChampionSelectPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private IChampionSelectController controller;
	private AvailableChampionsModel model1;
	private AvailableChampionsModel model2;
	
	public ChampionSelectPanel(Session session, IChampionSelectController controller) {
		this.controller = controller;
		this.model1 = controller.getModel();
		this.model2 = controller.getModel();
		
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(480, 0, 1, 550);
		add(separator);
		
		ChampionSelectComponent user1 = new ChampionSelectComponent(session.getUser1(), model1);
		user1.setBounds(0,0, 480, 720);
		add(user1);
		
		ChampionSelectComponent user2 = new ChampionSelectComponent(session.getUser2(), model2);
		user2.setBounds(480,0, 480, 720);		
		add(user2);
		
		JButton loginButton = new JButton("Start");
		loginButton.setBounds(331, 585, 300, 47);
		add(loginButton);
	}
}
