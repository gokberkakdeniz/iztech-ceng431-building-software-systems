package tr.edu.iztech.orp.controllers;

import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.views.components.CollectionListPanel;

public class CollectionListController implements IController {
	private final CollectionListPanel view;
	private final User model;
	
	public CollectionListController(CollectionListPanel view, User model) {
		this.model = model;
		this.view = view;
		
		this.model.subscribe(UserEvent.ADD_COLLECTION, view);
		this.model.subscribe(UserEvent.REMOVE_COLLECTION, view);
	}
    
	@Override
	public void destroy() {
		this.model.unsubscribe(UserEvent.ADD_COLLECTION, view);
		this.model.unsubscribe(UserEvent.REMOVE_COLLECTION, view);
	}
}
