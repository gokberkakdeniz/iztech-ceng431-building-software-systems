package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ChampSelectComponent extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	public ChampSelectComponent() {		
		setLayout(null);
		setBounds(0,0, 480, 720);
		
		JButton btnNewButton = new JButton("Lightbringer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblChooseAnOrigin = new JLabel("Choose an Origin");
		lblChooseAnOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnOrigin.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAnOrigin.setBounds(0, 45, 480, 30);
		add(lblChooseAnOrigin);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(30, 95, 130, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dragonslayer");
		btnNewButton_1.setBounds(30, 140, 130, 25);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Ironclad");
		btnNewButton_1_1.setBounds(30, 185, 130, 25);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Chrono");
		btnNewButton_1_1_1.setBounds(30, 230, 130, 25);
		add(btnNewButton_1_1_1);
		
		JLabel lblChooseAHero = new JLabel("Choose a Hero");
		lblChooseAHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAHero.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblChooseAHero.setBounds(0, 280, 480, 30);
		add(lblChooseAHero);
		
		JButton btnNewButton_1_2 = new JButton("Cavalier");
		btnNewButton_1_2.setBounds(30, 380, 130, 25);
		add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_2 = new JButton("God-King");
		btnNewButton_1_1_2.setBackground(Color.RED);
		btnNewButton_1_1_2.setBounds(30, 425, 130, 25);
		add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Demolitionist");
		btnNewButton_1_1_1_1.setBounds(30, 470, 130, 25);
		add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Cavalier");
		btnNewButton_1_2_1.setBounds(30, 335, 130, 25);
		add(btnNewButton_1_2_1);
		
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
		
        JLabel lblAnnesikici = new JLabel("Annesikici31");
		lblAnnesikici.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		lblAnnesikici.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnesikici.setBounds(160, 2, 160, 30);
		add(lblAnnesikici);
		
		
		
	}
}
