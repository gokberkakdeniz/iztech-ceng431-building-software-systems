package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.views.components.CollectionListPanel;
import tr.edu.iztech.orp.views.components.OutfitListPanel;
import tr.edu.iztech.orp.views.components.UserListPanel;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FollowedUsersPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;

	public FollowedUsersPanel() {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        JPanel userList = new UserListPanel();
        userList.setBounds(10, 20, 300, 540);
        add(userList);
        
        JPanel collectionList = new CollectionListPanel(null);
        collectionList.setBounds(330, 20, 300, 540);
        add(collectionList);
        
        OutfitListPanel outfitList = new OutfitListPanel();
        outfitList.addListSelectionListener(collectionChangeListener);
        outfitList.setBounds(650, 20, 300, 540);
		add(outfitList);
		
		final JPanel thisPanel = this;
		
        JButton followButton = new JButton("Follow New");
        followButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Object[] possibilities = {"User Aasgf", "User lasdfg", "User Cafgas", "User Eadfgadfg"};
        		JOptionPane.showInputDialog(
    				thisPanel,
                    "Please choose user to follow",
                    "Follow new User",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    null);
        	}
        });
        followButton.setBounds(10, 570, 140, 30);
        add(followButton);
		
        JButton unfollowButton = new JButton("Unfollow");
        unfollowButton.setBounds(170, 570, 140, 30);
        add(unfollowButton);

	}
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			System.out.println(event.getSource());
    		}
    	}
    };
}
