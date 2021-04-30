package tr.edu.iztech.orp.views;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CollectionsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;

	public CollectionsPanel() {
		setLayout(null);
		setBounds(0, 35, 960, 720);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(166, 5, 117, 25);
		add(btnNewButton);

	}
}
