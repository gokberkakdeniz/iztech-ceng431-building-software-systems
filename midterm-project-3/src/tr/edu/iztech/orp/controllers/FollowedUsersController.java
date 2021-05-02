package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.CollectionListPanel;
import tr.edu.iztech.orp.views.screens.FollowedUsersPanel;

public class FollowedUsersController implements IController {
	private FollowedUsersPanel view;
	private User model;
	
	public FollowedUsersController(FollowedUsersPanel view, User model) {
		this.model = model;
		this.view = view;
		
		this.view.addUserListSelectionListener(userListChangeListener);
		this.view.addFollowButtonListener(followButtonActionListener);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	private ListSelectionListener userListChangeListener = new ListSelectionListener() {
    	@SuppressWarnings("unchecked")
		public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			User model = ((JList<User>)event.getSource()).getSelectedValue();
    			
    			if (model != null) {
    				CollectionListPanel collectionList = new CollectionListPanel(model);
        			new CollectionListController(collectionList, model);
        			view.setCollectionListPanel(collectionList);
    			} else {
        			view.setCollectionListPanel(null);
    			}
    		}
    	}
    };

    private ActionListener followButtonActionListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		Object[] possibilities = {"User Aasgf", "User lasdfg", "User Cafgas", "User Eadfgadfg"};
    		JOptionPane.showInputDialog(
    			view,
                "Please choose user to follow",
                "Follow new User",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                null);
    	}
    };
}
