package tr.edu.iztech.lol.view.screen;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import tr.edu.iztech.lol.controller.ILoginController;

import javax.swing.JSeparator;
import javax.swing.JList;

public class StatisticsPanel extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;
	private final JLabel usernameLabel;
	private final JTextField usernameInput;
	
	public StatisticsPanel() {
		setLayout(null);
		setBounds(0,0, 960, 720);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(673, 31, 100, 20);
		add(usernameLabel);
		
		usernameInput = new JTextField();
		usernameInput.setColumns(10);
		usernameInput.setBounds(620, 56, 200, 20);
		add(usernameInput);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(480, 0, 1, 550);
		add(separator);
		
		String[] k = {"<html><li>Hakan, Win: 1613, Lose: 13151",
				"<html><li>aafg, Win: 2345, Lose: 1351451",
				"<html><li>asfg Win: 1145613, Lose: 131551",
				"<html><li>Haafgp, Win: 161245113, Lose: 135151",
				"<html><li>Haasfga: 124, Lose: 135151",
				"<html><li>Haagp, Win: 1614513, Lose: 135151",
				"<html><li>sdfasg, Win: 16142513, Lose: 15351",
				"<html><li>sdfg, Win: 161513, Lose: 1351",
				"<html><li>afgafdg, Win: 12513, Lose: 15351",
				"<html><li>afgagf, Win: 162513, Lose: 1351",
				};
		JList list = new JList(k);
		list.setBackground(new Color(0, 0, 0, 0));
		list.setBounds(10, 120, 400, 400);
		add(list);
		
		
		String[] k2 = {"<html><li>Won versus Username2<br />Winner stats: HERO NAME <br />Initial: {AD:123, HP:124524, CC: 345} <br />End: {AD:123, HP:124524, CC: 345}<br />Loser stats: HERO NAME <br />Initial {AD:123, HP:124524, CC: 345}",

				};
		JList list2 = new JList(k2);
		list2.setFixedCellHeight(110);
		list2.setBackground(new Color(0, 0, 0, 0));
		list2.setBounds(490, 120, 460, 400);
		add(list2);
		
		JLabel lblTopWinners = new JLabel("Top 10 Winners");
		lblTopWinners.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblTopWinners.setBounds(45, 60, 160, 25);
		add(lblTopWinners);
		
	}
}
