package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.models.User;

public class UserListPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JScrollPane usersScroller;
	private JList<Object> users;
	private User model;
	
	public UserListPanel(User model) {
		this.model = model;
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
              
        usersScroller = new JScrollPane();
        usersScroller.setBounds(0, 30, 300, 510);
        usersScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        usersScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(usersScroller);

        users = new JList<Object>(model.getFollowedUsers().toArray());
        users.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        users.setVisibleRowCount(-1);
        
        usersScroller.setViewportView(users);
        
        JLabel usersTitle = new JLabel("Users");
        usersTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        usersTitle.setBounds(0, 0, 140, 15);
        add(usersTitle);

	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        users.addListSelectionListener(collectionChangeListener);
        users.setSelectedIndex(0);
	}
}
