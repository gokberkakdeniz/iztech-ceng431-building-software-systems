package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import tr.edu.iztech.lol.model.AvailableChampions;
import tr.edu.iztech.lol.model.ChampionSelectModel;
import tr.edu.iztech.lol.model.User;
import tr.edu.iztech.lol.utils.IObservable;
import tr.edu.iztech.lol.utils.IObserver;

public class ChampionSelectComponent extends JPanel implements IObserver<ChampionSelectModel> {
	private static final long serialVersionUID = 5232858854896059657L;
	private JButton originButton1;
	private JButton originButton2;
	private JButton originButton3;
	private JButton originButton4;
	private JButton heroButton1;
	private JButton heroButton2;
	private JButton heroButton3;
	private JButton heroButton4;
	private JLabel originDescriptionLabel;
	private JLabel heroDescriptionLabel;
	private ChampionSelectModel model;
	
	public ChampionSelectComponent(ChampionSelectModel model) {
		this.model = model;
		AvailableChampions availableChampions = model.getAvailableChampions();
		List<String> heroNames = availableChampions.getHeroNames();
		List<String> originNames = availableChampions.getOriginNames();
		
		setLayout(null);
		setBounds(0,0, 480, 550);
		
        JLabel usernameLabel = new JLabel(model.getUser().getUsername());
		usernameLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(160, 2, 160, 30);
		add(usernameLabel);	
		
		JLabel lblChooseAnOrigin = new JLabel("Choose an Origin");
		lblChooseAnOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnOrigin.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAnOrigin.setBounds(0, 45, 480, 30);
		add(lblChooseAnOrigin);
		
		originButton1 = new JButton(originNames.get(0));
		originButton1.setBounds(30, 95, 130, 25);
		add(originButton1);
		
		originButton2 = new JButton(originNames.get(1));
		originButton2.setBounds(30, 140, 130, 25);
		add(originButton2);
		
		originButton3 = new JButton(originNames.get(2));
		originButton3.setBounds(30, 185, 130, 25);
		add(originButton3);
		
		originButton4 = new JButton(originNames.get(3));
		originButton4.setBounds(30, 230, 130, 25);
		add(originButton4);
		
		JLabel lblChooseAHero = new JLabel("Choose a Hero");
		lblChooseAHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAHero.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAHero.setBounds(0, 280, 480, 30);
		add(lblChooseAHero);
		
		heroButton1 = new JButton(heroNames.get(0));
		heroButton1.setBounds(30, 335, 130, 25);
		add(heroButton1);
		
		heroButton2 = new JButton(heroNames.get(1));
		heroButton2.setBounds(30, 380, 130, 25);
		add(heroButton2);
		
		heroButton3 = new JButton(heroNames.get(2));
		heroButton3.setBounds(30, 425, 130, 25);
		add(heroButton3);
		
		heroButton4 = new JButton(heroNames.get(3));
		heroButton4.setBounds(30, 470, 130, 25);
		add(heroButton4);
		
		
		originDescriptionLabel = new JLabel("");
		originDescriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		originDescriptionLabel.setVerticalAlignment(SwingConstants.TOP);
		originDescriptionLabel.setBounds(200, 95, 240, 160);
		add(originDescriptionLabel);
		
		heroDescriptionLabel = new JLabel("");
		heroDescriptionLabel.setVerticalAlignment(SwingConstants.TOP);
		heroDescriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		heroDescriptionLabel.setBounds(200, 335, 240, 160);
		add(heroDescriptionLabel);
		
		update();
	}
	
	public void addOriginButtonsListener(ActionListener listener) {
		originButton1.addActionListener(listener);
		originButton2.addActionListener(listener);
		originButton3.addActionListener(listener);
		originButton4.addActionListener(listener);
	}
	
	public void addHeroButtonsListener(ActionListener listener) {
		heroButton1.addActionListener(listener);
		heroButton2.addActionListener(listener);
		heroButton3.addActionListener(listener);
		heroButton4.addActionListener(listener);
	}
	
	@Override
	public void update() {
		updateOriginButtons();
		updateHeroButtons();
		updateOriginDescription();
		updateHeroDescription();
		
	}
	
	private void updateOriginButtons() {
		updateOriginButtonBackground(originButton1);
		updateOriginButtonBackground(originButton2);
		updateOriginButtonBackground(originButton3);
		updateOriginButtonBackground(originButton4);
	}
	
	private void updateHeroButtons() {
		updateHeroButtonBackground(heroButton1);
		updateHeroButtonBackground(heroButton2);
		updateHeroButtonBackground(heroButton3);
		updateHeroButtonBackground(heroButton4);
	}
	
	private void updateOriginButtonBackground(JButton button) {
		button.setBackground(button.getText().equals(model.getSelectedOrigin()) ? Color.RED : null);
	}
	
	private void updateHeroButtonBackground(JButton button) {
		button.setBackground(button.getText().equals(model.getSelectedHero()) ? Color.RED : null);
	}
	
	private void updateOriginDescription() {
		originDescriptionLabel.setText(makeHTML(model.getAvailableChampions().getOriginDescription(model.getSelectedOrigin())));
		
	}

	private void updateHeroDescription() {
		heroDescriptionLabel.setText(makeHTML(model.getAvailableChampions().getHeroDescription(model.getSelectedHero())));		
	}
	
	private String makeHTML(String text) {
		return String.format("<html>%s</html>", text);
	}

}
