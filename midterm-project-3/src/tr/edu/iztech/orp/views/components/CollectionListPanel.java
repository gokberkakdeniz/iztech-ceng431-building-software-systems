package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;

public class CollectionListPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JScrollPane usersScroller;
	private JList<Object> users;
	
	public CollectionListPanel() {
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
        
        String[] userArr = {"<html> ASDFASF: alksfjafsdgLKXSDC <br/> sşfdlkgasdgf", "SLKAJFAS: sgşlkjasfg", "DSLFKGDAGF: şlkdfgşlasdkgf", "ADŞGMFA: aşdflgag", "DFGADFG: asfgklasjg", "KLJDSGFHDS: kalfdjhafdg", "JASKLFGJASG: kdjfgsagf"};
        
        usersScroller = new JScrollPane();
        usersScroller.setBounds(0, 30, 300, 510);
        usersScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        usersScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(usersScroller);

        users = new JList<Object>(userArr);
        users.setSelectedIndex(0);
        users.addListSelectionListener(collectionChangeListener);
        users.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        users.setVisibleRowCount(-1);
        
        usersScroller.setViewportView(users);
        
        JLabel usersTitle = new JLabel("Collections");
        usersTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        usersTitle.setBounds(0, 0, 140, 15);
        add(usersTitle);

	}
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			System.out.println(users.getSelectedValue());
    		}
    	}
    };
}
