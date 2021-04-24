package tr.edu.iztech.orp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JButton btnNewButton;
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
		frame.setTitle("IZTECH Outfit Rating Platform");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.getContentPane().remove(1);
				} catch (Exception ignored) {
				}

				if (panel instanceof LoginPanel) {
					panel = new HomePanel();
				} else {
					panel = new LoginPanel();
				}
				
				frame.getContentPane().add(panel, BorderLayout.SOUTH);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
	}
}
