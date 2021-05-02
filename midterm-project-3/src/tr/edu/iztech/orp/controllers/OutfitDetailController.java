package tr.edu.iztech.orp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tr.edu.iztech.orp.app.Session;
import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.models.Comment;
import tr.edu.iztech.orp.models.Outfit;
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
    		if (text.length() == 0) return;
    		model.addComment(new Comment(Session.getUser(), text));
    	}
    };
    
	@Override
	public void destroy() {
		for (OutfitEvent event : OutfitEvent.values()) {
			this.model.unsubscribe(event, view);
		}
	}
}
