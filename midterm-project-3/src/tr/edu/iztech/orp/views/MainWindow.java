package tr.edu.iztech.orp.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.Box;


public class MainWindow extends JFrame {
	private static final long serialVersionUID = -1913034844784098376L;
	private static final String title = "IZTECH Outfit Rating Platform [Group 6]";
	private JPanel contentPanel;
	private JPanel headerPanel;
	private JPanel loginPanel;
	
	private boolean isLoggedIn = false;

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		Container contentPane = getContentPane();
		
		setBounds(100, 100, 960, 720);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		ItemListener navigationHandler = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				changeContent((MenuModel) e.getItem());
			}
		};
		ActionListener logoutHandler = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isLoggedIn = false;
				headerPanel.setVisible(isLoggedIn);
				changeContent(MenuModel.LOGIN);
				
			}
		};
		
		headerPanel = new HeaderPanel(navigationHandler, logoutHandler);
		contentPane.add(headerPanel, BorderLayout.NORTH);
		contentPane.add(contentPanel, BorderLayout.CENTER);
		headerPanel.setVisible(isLoggedIn);
		
		loginPanel = new LoginPanel(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isLoggedIn = true;
				headerPanel.setVisible(isLoggedIn);
				changeContent(MenuModel.getDefault());		
			}
		});
		
		changeContent(MenuModel.LOGIN);
	}
	
	private void changeContent(MenuModel model) {
		contentPanel.removeAll();
		
		Component component;
		switch (model) {
			case LOGIN: 
				component = loginPanel;
				break;
			case HOME: 
				component = new HomePanel();
				break;
			default:
				component = new JLabel(model.toString());
				break;
		}
	
		contentPanel.add(component, BorderLayout.NORTH);
		
		contentPanel.repaint();
		contentPanel.revalidate();
	}
}
