package tr.edu.iztech.orp.views.screens;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.CollectionListPanel;
import tr.edu.iztech.orp.views.components.OutfitListPanel;
import tr.edu.iztech.orp.views.components.UserListPanel;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FollowedUsersPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private User model;
	private UserListPanel userList;
	private JButton followButton;
	private CollectionListPanel collectionList;
	private OutfitListPanel<?,?> outfitList;
	
	public FollowedUsersPanel(User model) {
		this.model = model;
		
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        userList = new UserListPanel(model);
        userList.setBounds(10, 20, 300, 540);
        add(userList);
        

//        OutfitListPanel outfitList = new OutfitListPanel<>();
//        outfitList.addListSelectionListener(collectionChangeListener);
//        outfitList.setBounds(650, 20, 300, 540);
//		add(outfitList);
		
		
        followButton = new JButton("Follow New");
        followButton.setBounds(10, 570, 140, 30);
        add(followButton);
		
        JButton unfollowButton = new JButton("Unfollow");
        unfollowButton.setBounds(170, 570, 140, 30);
        add(unfollowButton);

	}
	
	public void addUserListSelectionListener(ListSelectionListener collectionChangeListener) {
        userList.addListSelectionListener(collectionChangeListener);
	}
	
	public void addFollowButtonListener(ActionListener followButtonActionListener) {
		followButton.addActionListener(followButtonActionListener);
	}

	public void setCollectionListPanel(CollectionListPanel collectionList) {
		if (this.collectionList != null) remove(this.collectionList);
		
		if (collectionList != null) {
			this.collectionList = collectionList;
			this.collectionList.setBounds(330, 20, 300, 540);;
	        add(this.collectionList);
		}

		repaint();
		revalidate();		
	}
}
