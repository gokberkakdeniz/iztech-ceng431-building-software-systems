package tr.edu.iztech.orp.views;

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainWindow extends JFrame implements IWindow {
	private static final long serialVersionUID = -1913034844784098376L;
	private static final String title = "IZTECH Outfit Rating Platform [Group 6]";
	private JPanel contentPanel;
	private JPanel headerPanel;

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		Container contentPane = getContentPane();

		contentPane.setLayout(null);

		setBounds(100, 100, 960, 720);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		// Header: When user logged in navigation menu, logout button etc. show up here.
		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		headerPanel.setBounds(0, 0, 955, 35);
		contentPane.add(headerPanel);
		
		// Content: Pages show up here.
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 35, 960, 685);
		contentPane.add(contentPanel);

	}
	
	/*
	 * Set header panel.
	 * 
	 * Example use: When user logged out, remove header.
	 */
	public void setHeader(Component component) {
		changeContentOfPanel(headerPanel, component);
	}
	
	/*
	 * Set content panel.
	 * 
	 * Example use: While changing pages, set it to next page.
	 */
	public void setContent(Component component) {
		changeContentOfPanel(contentPanel, component);
	}
	
	protected void changeContentOfPanel(JPanel panel, Component component) {
		panel.removeAll();
		if (component != null) panel.add(component);
		panel.repaint();
		panel.revalidate();
	}
}
