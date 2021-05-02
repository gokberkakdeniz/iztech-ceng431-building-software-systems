package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.enums.UserEvent;
import tr.edu.iztech.orp.models.User;
import tr.edu.iztech.orp.utils.IObserver;

public class CollectionListPanel extends JPanel implements IObserver<User, UserEvent> {
	private static final long serialVersionUID = -669293105768399715L;
	private JScrollPane usersScroller;
	private JList<Object> collections;
	private User model;
	
	public CollectionListPanel(User model) {
		this.model = model;
		
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
                
        usersScroller = new JScrollPane();
        usersScroller.setBounds(0, 30, 300, 510);
        usersScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        usersScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(usersScroller);

        collections = new JList<Object>(model.getCollections().toArray());
        collections.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        collections.setVisibleRowCount(-1);
        
        usersScroller.setViewportView(collections);
        
        JLabel usersTitle = new JLabel("Collections");
        usersTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        usersTitle.setBounds(0, 0, 140, 15);
        add(usersTitle);

	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        collections.addListSelectionListener(collectionChangeListener);
        collections.setSelectedIndex(0);
	}
	
	@Override
	public void update(UserEvent event) {
		switch (event) {
			case ADD_COLLECTION:
			case REMOVE_COLLECTION:
				collections.removeAll();
				collections.setListData(model.getCollections().toArray());
			default:
				break;
		}		
	}
}
