package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import tr.edu.iztech.orp.enums.OutfitEvent;
import tr.edu.iztech.orp.enums.OutfitSize;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.utils.IObserver;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.Font;

/**
 * Shows all details of outfit. 
 * Shows like/dislike/comment like buttons.
 * 
 * Subscribes its details to keep itself updated.
 */
public class OutfitDetailPanel extends JPanel implements IObserver<Outfit, OutfitEvent> {
	private static final long serialVersionUID = -669290185768399715L;
	private Outfit model;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel brandLabel;
	private JLabel clothingTypeLabel;
	private JLabel occassionLabel;
	private JLabel likeCountLabel;
	private JLabel genderLabel;
	private JLabel sizeLabel;
	private JLabel colorLabel;
	private JLabel dislikeCountLabel;
	private JButton sendButton;
	private JTextArea commentField;
	private JButton likeButton; 
	private JButton addCollectionButton;
	private JButton dislikeButton;
	private JList<Object> comments;
	
	public OutfitDetailPanel(JPanel parent, Outfit model) {
		this.model = model;
        setSize(420, 685);
        setLayout(null);
        setVisible(true);
                        
        JScrollPane commentsScroller = new JScrollPane();
        commentsScroller.setBounds(0, 150, 420, 350);
        add(commentsScroller);
        commentsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        comments = new JList<Object>(model.getComments().toArray());
        comments.setFont(new Font("Dialog", Font.PLAIN, 12));
        comments.setFixedCellHeight(20);
        commentsScroller.setViewportView(comments);
        comments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        comments.setVisibleRowCount(-1);
        
        idLabel = new JLabel("Id: " + model.getId());
        idLabel.setBounds(0, 0, 129, 15);
        add(idLabel);
        
        nameLabel = new JLabel("Name: " + model.getName());
        nameLabel.setBounds(0, 30, 157, 15);
        add(nameLabel);
        
        brandLabel = new JLabel("Brand: " + model.getBrandName());
        brandLabel.setBounds(160, 30, 129, 15);
        add(brandLabel);
        
        clothingTypeLabel = new JLabel("Type: " + model.getType());
        clothingTypeLabel.setBounds(160, 57, 164, 15);
        add(clothingTypeLabel);
        
        occassionLabel = new JLabel("Ocassion: " + model.getOccasion());
        occassionLabel.setBounds(0, 60, 157, 15);
        add(occassionLabel);
        
        genderLabel = new JLabel("Gender: " + model.getGender());
        genderLabel.setBounds(160, 90, 129, 15);
        add(genderLabel);
        
        sizeLabel = new JLabel("Sizes: " + Stream.of(model.getSizes()).map(OutfitSize::toString).collect(Collectors.joining(", ")));
        sizeLabel.setBounds(0, 90, 276, 15);
        add(sizeLabel);
        
        colorLabel = new JLabel("Colors: " + model.getColor());
        colorLabel.setBounds(300, 90, 117, 15);
        add(colorLabel);
        
        likeCountLabel = new JLabel("Likes: " + model.getLikeCount());
        likeCountLabel.setBounds(0, 125, 129, 15);
        add(likeCountLabel);
        
        dislikeCountLabel = new JLabel("Dislikes: " + model.getDislikeCount());
        dislikeCountLabel.setBounds(160, 123, 129, 15);
        add(dislikeCountLabel);
        
        sendButton = new JButton("Send");
        sendButton.setBounds(310, 602, 110, 25);
        add(sendButton);
        
        commentField = new JTextArea();
        commentField.setText("");
        commentField.setBounds(0, 550, 420, 40);
        commentField.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        add(commentField);
        
        likeButton = new JButton("Like");
        likeButton.setBounds(0, 510, 110, 25);
        add(likeButton);
                
        addCollectionButton = new JButton("Add Collection");        
        addCollectionButton.setBounds(270, 510, 150, 25);
        add(addCollectionButton);
        
        dislikeButton = new JButton("Dislike");
        dislikeButton.setBounds(135, 510, 110, 25);
        add(dislikeButton);
        
	}
	
	public void addAddToCollectionButtonListener(ActionListener listener) {
		addCollectionButton.addActionListener(listener);
	}
	
	public void addLikeButtonListener(ActionListener listener) {
		likeButton.addActionListener(listener);
	}
	
	public void addDislikeButtonListener(ActionListener listener) {
		dislikeButton.addActionListener(listener);
	}
	
	public void addSendButtonListener(ActionListener listener) {
		sendButton.addActionListener(listener);
	}
	
	public String getCommentText() {
		return commentField.getText();
	}

	@Override
	public void update(OutfitEvent event) {
		switch (event) {
			case DISLIKE:
			case REMOVE_DISLIKE:
				dislikeCountLabel.setText("Dislikes: " + model.getDislikeCount());
				break;
			case LIKE:
			case REMOVE_LIKE:
				likeCountLabel.setText("Likes: " + model.getLikeCount());
				break;
			case ADD_COMMENT:
			case REMOVE_COMMENT:
				comments.removeAll();
				comments.setListData(model.getComments().toArray());
			default:
				break;
		}
	}
}
