package tr.edu.iztech.lol.view;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 967053716712023043L;
	private JPanel contentPanel;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Container contentPane = getContentPane();

		contentPane.setLayout(null);

		setBounds(100, 0, 960, 720);
		setTitle("LOL");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 0, 960, 720);
		contentPane.add(contentPanel);
		
//		LoginPanel loginPanel = new LoginPanel();
//		setContent(loginPanel);
		
//		ChampSelectPanel champSelectPanel = new ChampSelectPanel();
//		setContent(champSelectPanel);
		
//		ChampFightPanel champFightPanel = new ChampFightPanel();
//		setContent(champFightPanel);
	}
	
	public void setContent(JPanel panel) {
		contentPanel.removeAll();
		contentPanel.add(panel);
		contentPanel.repaint();
		contentPanel.revalidate();
	}

}
