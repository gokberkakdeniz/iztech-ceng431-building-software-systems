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
        this.setSize(960, 680);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        
        String[] data = {"a", "b", "c", "d", "e", "f", "g"};
        	
		
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(90, 5, 300, 600);
        listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScroller.setPreferredSize(new Dimension(300, 600));
        JList<Object> list = new JList<Object>(data);
        listScroller.setViewportView(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(-1);
        	
        container.setSize(960, 680);
        panelOne.setSize(300, 680);
        panelTwo.setSize(660, 680);
        panelOne.setLayout(null);
        
        panelOne.add(listScroller);

        container.setLayout(new GridLayout(1,2));
        container.add(panelOne);
        
        JButton btnNewButton = new JButton("Create New Collection");
        btnNewButton.setBounds(283, 609, 117, 25);
        panelOne.add(btnNewButton);
        container.add(panelTwo);
        panelTwo.setLayout(null);
        
        String[] data_2 = {"ASDFASF: alksfjafsdgLKXSDC", "SLKAJFAS: sgşlkjasfg", "DSLFKGDAGF: şlkdfgşlasdkgf", "ADŞGMFA: aşdflgag", "DFGADFG: asfgklasjg", "KLJDSGFHDS: kalfdjhafdg", "JASKLFGJASG: kdjfgsagf"};
        panelOne.setVisible(true);
        
        
        
        this.add(container);
        


//    

	}
}
