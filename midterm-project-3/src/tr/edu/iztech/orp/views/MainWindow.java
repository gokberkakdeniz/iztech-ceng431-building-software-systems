package tr.edu.iztech.orp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainWindow {
	private static final String title = "IZTECH Outfit Rating Platform";

	private JFrame frame;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 720);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JComboBox<MenuModel> viewCombo = new JComboBox<MenuModel>();
		viewCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(event);
				}
			}
		});
		viewCombo.setModel(new DefaultComboBoxModel<>(MenuModel.values()));
		headerPanel.add(viewCombo);
		
		JButton logoutButton = new JButton("Logout");
		headerPanel.add(logoutButton);
		
		JPanel contentPanel = new JPanel();
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
	}
	
	private enum MenuModel {
		HOME("Home"),
		COLLECTIONS("Collections"),
		SUBSCRIBED_USERS("Subscribed Users");
		
	    private final String text;

	    MenuModel(String text) {
	        this.text = text;
	    }

	    @Override
	    public String toString() {
	        return text;
		}
	}
}
