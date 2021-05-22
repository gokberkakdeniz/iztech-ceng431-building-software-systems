package tr.edu.iztech.lol.view.component;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ChampionFightComponent extends JPanel {
	private static final long serialVersionUID = 5232858854896059657L;

	public ChampionFightComponent() {		
		this(false)	;
	}
	
	public ChampionFightComponent(boolean rightToLeft) {		
		setLayout(null);
		setBounds(0,0, 480, 430);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setBounds(10, 50, 458, 25);
		add(progressBar);
		
		progressBar.setComponentOrientation(rightToLeft ? ComponentOrientation.RIGHT_TO_LEFT : ComponentOrientation.LEFT_TO_RIGHT);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Noto Sans CJK SC Light", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 15, 480, 25);
		add(lblNewLabel);	
	}
	

}
