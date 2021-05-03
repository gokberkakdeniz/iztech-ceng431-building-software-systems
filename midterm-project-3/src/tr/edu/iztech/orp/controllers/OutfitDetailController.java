package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tr.edu.iztech.orp.app.Session;
import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.models.Comment;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.models.OutfitCollection;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.utils.StringUtils;
import tr.edu.iztech.orp.views.components.OutfitDetailPanel;

public class OutfitDetailController implements IController {
	private final OutfitDetailPanel view;
	private final Outfit model;
	
	public OutfitDetailController(OutfitDetailPanel view, Outfit model) {
		this.model = model;
		this.view = view;
		
		for (OutfitEvent event : OutfitEvent.values()) {
			this.model.subscribe(event, view);
		}
		
		view.addLikeButtonListener(likeButtonListener);
		view.addDislikeButtonListener(dislikeButtonListener);
		view.addSendButtonListener(sendButtonListener);
		view.addAddToCollectionButtonListener(addCollectionButtonListener);
	}
	
	private ActionListener likeButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		boolean succeed = model.addLike(Session.getUser());
    		if (!succeed) model.removeLike(Session.getUser());
    	}
    };
	
	private ActionListener dislikeButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		boolean succeed = model.addDislike(Session.getUser());
    		if (!succeed) model.removeDislike(Session.getUser());
    	}
    };
	
	private ActionListener sendButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent event) {
    		String text = view.getCommentText();
    		if (StringUtils.isValid(text)) model.addComment(new Comment(Session.getUser(), text));
    	}
    };
    
    private ActionListener addCollectionButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		User user = Session.getUser();
    		
    		Object[] possibilities = user.getCollections().toArray();
    		OutfitCollection result = (OutfitCollection) JOptionPane.showInputDialog(
                view,
                "Please Choose collection to add",
                "Add to Collection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                null
    		);

    		if (result != null) {
    			result.add(model);
    		}

    	}
    };
    
	@Override
	public void destroy() {
		for (OutfitEvent event : OutfitEvent.values()) {
			this.model.unsubscribe(event, view);
		}
	}
}
