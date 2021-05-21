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

import tr.edu.iztech.lol.model.User;

public class ChampSelectComponent extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	public ChampSelectComponent(User user, List<String> heroNames, List<String> originNames) {
		setLayout(null);
		setBounds(0,0, 480, 720);
		
		JLabel lblChooseAnOrigin = new JLabel("Choose an Origin");
		lblChooseAnOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnOrigin.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAnOrigin.setBounds(0, 45, 480, 30);
		add(lblChooseAnOrigin);
		
		JButton originButton1 = new JButton(originNames.get(0));
		originButton1.setBackground(Color.RED);
		originButton1.setBounds(30, 95, 130, 25);
		add(originButton1);
		
		JButton originButton2 = new JButton(originNames.get(1));
		originButton2.setBounds(30, 140, 130, 25);
		add(originButton2);
		
		JButton originButton3 = new JButton(originNames.get(2));
		originButton3.setBounds(30, 185, 130, 25);
		add(originButton3);
		
		JButton originButton4 = new JButton(originNames.get(3));
		originButton4.setBounds(30, 230, 130, 25);
		add(originButton4);
		
		JLabel lblChooseAHero = new JLabel("Choose a Hero");
		lblChooseAHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAHero.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAHero.setBounds(0, 280, 480, 30);
		add(lblChooseAHero);
		
		JButton heroButton1 = new JButton(heroNames.get(0));
		heroButton1.setBounds(30, 380, 130, 25);
		add(heroButton1);
		
		JButton heroButton2 = new JButton(heroNames.get(1));
		heroButton2.setBackground(Color.RED);
		heroButton2.setBounds(30, 425, 130, 25);
		add(heroButton2);
		
		JButton heroButton3 = new JButton(heroNames.get(2));
		heroButton3.setBounds(30, 470, 130, 25);
		add(heroButton3);
		
		JButton heroButton4 = new JButton(heroNames.get(3));
		heroButton4.setBounds(30, 335, 130, 25);
		add(heroButton4);
		
		JLabel lblChooseAHero_1 = new JLabel("Choose an Item");
		lblChooseAHero_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAHero_1.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAHero_1.setBounds(0, 510, 480, 30);
		add(lblChooseAHero_1);
		
		JLabel lblNewLabel = new JLabel(String.format("<html>%s</html>"
				,"fşdalgj kaşlskg şl askgşls kfgş laskf gşlak sfşga fhşl adfmh şladfa sfgaşlfkg şladkfgşl akfgşlk adfşglka dşlkmh şladm fhşladm hşaafd hgad"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(200, 95, 240, 160);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>fşdalgj kaşlskg şl askgşls kfgş laskf gşlak sfşga fhşl adfmh şladfa sfgaşlfkg şladkfgşl akfgşlk adfşglka dşlkmh şladm fhşladm hşaafd hgad</html>");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(200, 335, 240, 160);
		add(lblNewLabel_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Doran's Blade");
		btnNewButton_1_2_1_1.setBackground(Color.RED);
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1_1.setBounds(15, 570, 140, 25);
		add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_2_1_2 = new JButton("Cloak of Agility");
		btnNewButton_1_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1_2.setBounds(170, 570, 140, 25);
		add(btnNewButton_1_2_1_2);
		
		JButton btnNewButton_1_2_1_3 = new JButton("Cloth Armor");
		btnNewButton_1_2_1_3.setBounds(325, 570, 140, 25);
		add(btnNewButton_1_2_1_3);
		
		JButton btnNewButton_1_2_1_4 = new JButton("Thornmail");
		btnNewButton_1_2_1_4.setBounds(15, 625, 140, 25);
		add(btnNewButton_1_2_1_4);
		
		JButton btnNewButton_1_2_1_5 = new JButton("Ruby Crystal");
		btnNewButton_1_2_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1_5.setBounds(170, 625, 140, 25);
		add(btnNewButton_1_2_1_5);
		
		JButton btnNewButton_1_2_1_6 = new JButton("B.F. Sword");
		btnNewButton_1_2_1_6.setBackground(Color.RED);
		btnNewButton_1_2_1_6.setBounds(325, 625, 140, 25);
		add(btnNewButton_1_2_1_6);
		
        JLabel usernameLabel = new JLabel(user.getUsername());
		usernameLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(160, 2, 160, 30);
		add(usernameLabel);	
	}
}
