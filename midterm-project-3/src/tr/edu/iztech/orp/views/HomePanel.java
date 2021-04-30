package tr.edu.iztech.orp.views;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JTextField textField;

	public HomePanel() {
        this.setSize(960, 680);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        
        String[] data = {"a", "b", "c", "d", "e", "f", "g"};
        	
		
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(12, 12, 300, 600);
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
        
        Component glue = Box.createGlue();
        panelOne.add(glue);
        
        panelOne.add(listScroller);

        container.setLayout(new GridLayout(1,2));
        container.add(panelOne);
        container.add(panelTwo);
        panelTwo.setLayout(null);
        
        JLabel lblAsfgadfgadfgad = new JLabel("ID: asfgadfgadfgad");
        lblAsfgadfgadfgad.setBounds(40, 47, 152, 15);
        panelTwo.add(lblAsfgadfgadfgad);
        
        JLabel lblSize = new JLabel("Size: 31, 32, 33, 34");
        lblSize.setBounds(40, 77, 177, 15);
        panelTwo.add(lblSize);
        
        String[] data_2 = {"ASDFASF: alksfjafsdgLKXSDC", "SLKAJFAS: sgşlkjasfg", "DSLFKGDAGF: şlkdfgşlasdkgf", "ADŞGMFA: aşdflgag", "DFGADFG: asfgklasjg", "KLJDSGFHDS: kalfdjhafdg", "JASKLFGJASG: kdjfgsagf"};
        JScrollPane listScroller2 = new JScrollPane();
        listScroller2.setBounds(40, 200, 417, 350);
        listScroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScroller2.setPreferredSize(new Dimension(417, 350));
        JList<Object> list2 = new JList<Object>(data_2);
        list2.setFixedCellHeight(20);
        listScroller2.setViewportView(list2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list2.setVisibleRowCount(-1);
        panelTwo.add(listScroller2);
        
        JButton btnLike = new JButton("Like");
        btnLike.setBounds(40, 154, 117, 25);
        panelTwo.add(btnLike);
        
        JButton btnLike_1 = new JButton("Like");
        btnLike_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLike_1.setBounds(188, 154, 117, 25);
        panelTwo.add(btnLike_1);
        
        JButton btnLike_2 = new JButton("Like");
        btnLike_2.setBounds(337, 154, 117, 25);
        panelTwo.add(btnLike_2);
        
        textField = new JTextField();
        textField.setBounds(40, 562, 417, 19);
        panelTwo.add(textField);
        textField.setColumns(20);
        
        JButton btnNewButton = new JButton("Send");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(340, 584, 117, 25);
        panelTwo.add(btnNewButton);

        
        
        
        this.add(container);
        


//    

	}
}
