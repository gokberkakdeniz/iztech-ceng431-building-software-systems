package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import tr.edu.iztech.lol.model.TopWinnersModel;
import tr.edu.iztech.lol.utils.IObserver;

public class TopWinnersComponent extends JPanel implements IObserver<TopWinnersModel>{
	private static final long serialVersionUID = 5232858854896059657L;
	private JList<String> winnersList;
	private TopWinnersModel model;


	public TopWinnersComponent(TopWinnersModel model) {
		this.model = model;
		
		setLayout(null);
		setBounds(0,0,479,550);

		JLabel lblTopWinners = new JLabel("Top 10 Winners");
		lblTopWinners.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblTopWinners.setBounds(45, 60, 160, 25);
		add(lblTopWinners);
		
		winnersList = new JList<>();
		winnersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		winnersList.setBackground(new Color(0, 0, 0, 0));
		winnersList.setSelectionBackground(getBackground());

		winnersList.setBounds(10, 120, 460, 400);
		add(winnersList);
		winnersList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				repaint();
			}
		});
		update();
	}
	
	public void update() {
		winnersList.setListData(getTopWinnersAsString());
	}
	
	private String[] getTopWinnersAsString() {
		return model.getTopWinners().stream().
				map(user -> String.format("<html><li><b>%s:</b> Win Rate: %.2f, Win: %d, Lose: %d</html>", 
					user.getUsername(), user.getWinRate(), user.getWinCount(), user.getLoseCount())).toArray(String[]::new);
	}
	
 }
