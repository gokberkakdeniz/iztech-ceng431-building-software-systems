package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.enums.OutfitCollectionEvent;
import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.IRepository;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.CollectionListPanel;
import tr.edu.iztech.orp.views.components.OutfitListPanel;
import tr.edu.iztech.orp.views.screens.FollowedUsersPanel;

public class FollowedUsersController implements IController {
	private FollowedUsersPanel view;
	private User model;
	private CollectionListController collectionListController;
	private final IRepository<User> userRepo;
	
	public FollowedUsersController(FollowedUsersPanel view, User model, IRepository<User> userRepo) {
		this.model = model;
		this.view = view;
		this.userRepo = userRepo;
		
		this.view.addUserListSelectionListener(userListChangeListener);
		this.view.addFollowButtonListener(followButtonActionListener);
		this.view.addUnfollowButtonListener(unfollowButtonActionListener);
		
		this.model.subscribe(UserEvent.FOLLOW, view.getUserListPanel());
		this.model.subscribe(UserEvent.UNFOLLOW, view.getUserListPanel());
	}
	
	@Override
	public void destroy() {
		if (collectionListController != null) collectionListController.destroy();
		
		this.model.unsubscribe(UserEvent.FOLLOW, view.getUserListPanel());
		this.model.unsubscribe(UserEvent.UNFOLLOW, view.getUserListPanel());
	}
	
	private ListSelectionListener userListChangeListener = new ListSelectionListener() {
    	@SuppressWarnings("unchecked")
		public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (collectionListController != null) collectionListController.destroy();
    			
    			User model = ((JList<User>)event.getSource()).getSelectedValue();
    			
    			if (model != null) {
    				CollectionListPanel collectionList = new CollectionListPanel(model);
    				collectionListController = new CollectionListController(collectionList, model);

        			view.setCollectionListPanel(collectionList);
        			
        			// controller or not controller?
        			view.addCollectionsListSelectionListener(collectionChangeListener);
    			} else {
        			view.setCollectionListPanel(null);
        			view.setOutfitListPanel(null);
    			}
    		}
    	}
    };
    
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			// TODO: Make controller and implement destroy;
    			
				OutfitCollection model = ((JList<OutfitCollection>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				OutfitListPanel<OutfitCollection, OutfitCollectionEvent> outfitListPanel = new OutfitListPanel<>(model);
    				
    				model.subscribe(OutfitCollectionEvent.ADD_OUTFIT, outfitListPanel);
    				model.subscribe(OutfitCollectionEvent.REMOVE_OUTFIT, outfitListPanel);

    				view.setOutfitListPanel(outfitListPanel);
    			} else {
    				view.setOutfitListPanel(null);
    			}
				
//				selectedCollection = model;
			}
    	}
    };

    private ActionListener followButtonActionListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		List<User> followedUsers = model.getFollowedUsers();
    		
    		List<User> possibilities = userRepo.getAll(u -> !followedUsers.contains(u));
    		possibilities.remove(model);
    		
    		User result = (User) JOptionPane.showInputDialog(
    			view,
                "Please choose user to follow",
                "Follow new User",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities.toArray(),
                null);
    		
    		if (result != null) {
    			// TODO: user1.(un)follow(user2) may call user2.(un)followedBy(user1).
    			model.follow(result);
    			result.followedBy(model);
    		}
    	}
    };
    
    private ActionListener unfollowButtonActionListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		User subject = view.getUserListPanel().getSelectedValue();
    		model.unfollow(subject);
    		subject.unfollowedBy(model);
    	}
    };
}