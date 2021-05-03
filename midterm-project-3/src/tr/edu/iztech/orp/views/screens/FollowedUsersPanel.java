package tr.edu.iztech.orp.views.screens;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.CollectionListPanel;
import tr.edu.iztech.orp.views.components.OutfitListPanel;
import tr.edu.iztech.orp.views.components.FollowedUsersListPanel;

/**
 * Shows user's followed users, their collections and items in these collections.
 * 
 * Behavior:
 * - The user select followed user.
 * - The followed user's collections show up at center..
 * - The user selects collection.
 * - The outfits of selected collection show up at right..
 * - The user follows/unfollows users from lower left.
 * 
 * Children:
 * - FollowedUsersListPanel
 * - CollectionListPanel
 * - OutfitListPanel
 */
public class FollowedUsersPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	private FollowedUsersListPanel userList;
	private JButton followButton;
	private CollectionListPanel collectionList;
	private OutfitListPanel<?,?> outfitList;
	private JButton unfollowButton;
	
	public FollowedUsersPanel(User model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        userList = new FollowedUsersListPanel(model);
        userList.setBounds(10, 20, 300, 540);
        add(userList);
		
        followButton = new JButton("Follow New");
        followButton.setBounds(10, 570, 140, 30);
        add(followButton);
		
        unfollowButton = new JButton("Unfollow");
        unfollowButton.setBounds(170, 570, 140, 30);
        add(unfollowButton);

	}
	
	public FollowedUsersListPanel getUserListPanel() {
		return userList;
	}
	
	public void addUserListSelectionListener(ListSelectionListener collectionChangeListener) {
        userList.addListSelectionListener(collectionChangeListener);
	}
	
	public void addFollowButtonListener(ActionListener followButtonActionListener) {
		followButton.addActionListener(followButtonActionListener);
	}
	
	public void addUnfollowButtonListener(ActionListener unfollowButtonActionListener) {
		unfollowButton.addActionListener(unfollowButtonActionListener);
	}
	
	public void addCollectionsListSelectionListener(ListSelectionListener collectionChangeListener) {
		collectionList.addListSelectionListener(collectionChangeListener);
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
	
	public void setOutfitListPanel(OutfitListPanel<?,?> outfitList) {
		if (this.outfitList != null) remove(this.outfitList);
		
		if (outfitList != null) {
			this.outfitList = outfitList;
			this.outfitList.setBounds(650, 20, 300, 540);
	        add(this.outfitList);
		}

		repaint();
		revalidate();		
	}
}
