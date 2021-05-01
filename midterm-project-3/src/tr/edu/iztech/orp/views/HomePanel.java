package tr.edu.iztech.orp.views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JScrollPane outfitsScroller;
	private JList<Object> outfits;
	
	public HomePanel() {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        String[] outfitArr = {"Outfit a", "Outfit sfaglk", "Outfit sgdlasf", "Outfit lkajsgfadfg", "Outfit klfsghnad", "Outfit sdklfgasgf"};
        
        outfitsScroller = new JScrollPane();
        outfitsScroller.setBounds(20, 70, 300, 520);
        outfitsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outfitsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(outfitsScroller);

        outfits = new JList<Object>(outfitArr);
        outfits.setSelectedIndex(0);
        outfits.addListSelectionListener(collectionChangeListener);
        outfits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        outfits.setVisibleRowCount(-1);
        
        outfitsScroller.setViewportView(outfits);
        
        String[] commentArr = {"User a: alksfjafsdgLKXSDC", "User b: sgşlkjasfg", "User c: şlkdfgşlasdkgf", 
        		"User d: aşdflgag", "User e: asfgklasjg", "User f: kalfdjhafdg", "User g: kdjfgsagf"};
        
        
        JScrollPane commentsScroller = new JScrollPane();
        commentsScroller.setBounds(520, 150, 420, 350);
        add(commentsScroller);
        commentsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> comments = new JList<Object>(commentArr);
        comments.setFixedCellHeight(20);
        commentsScroller.setViewportView(comments);
        comments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        comments.setVisibleRowCount(-1);
        
        JLabel idLabel = new JLabel("Id: 3526");
        idLabel.setBounds(520, 30, 129, 15);
        add(idLabel);
        
        JLabel brandLabel = new JLabel("Brand: LC Waisiki");
        brandLabel.setBounds(680, 30, 129, 15);
        add(brandLabel);
        
        JLabel clothingTypeLabel = new JLabel("Type: Tshirt");
        clothingTypeLabel.setBounds(820, 60, 129, 15);
        add(clothingTypeLabel);
        
        JLabel occassionLabel = new JLabel("Ocassion: Party, Elegant");
        occassionLabel.setBounds(520, 60, 129, 15);
        add(occassionLabel);
        
        JLabel genderLabel = new JLabel("Gender: Female");
        genderLabel.setBounds(680, 60, 129, 15);
        add(genderLabel);
        
        JLabel sizeLabel = new JLabel("Sizes: XL, XXL");
        sizeLabel.setBounds(520, 90, 129, 15);
        add(sizeLabel);
        
        JLabel colorLabel = new JLabel("Colors: Red, White");
        colorLabel.setBounds(680, 90, 180, 15);
        add(colorLabel);
        
        JLabel likeCountLabel = new JLabel("Likes: 169");
        likeCountLabel.setBounds(520, 125, 129, 15);
        add(likeCountLabel);
        
        JLabel dislikeCountLabel = new JLabel("Dislikes: 31");
        dislikeCountLabel.setBounds(620, 125, 129, 15);
        add(dislikeCountLabel);
        
        JButton sendButton = new JButton("Send");
        sendButton.setBounds(830, 602, 110, 25);
        add(sendButton);
        
        JTextArea commentField = new JTextArea();
        commentField.setBounds(520, 550, 420, 40);
        commentField.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        add(commentField);
        
        JButton likeButton = new JButton("Like");
        likeButton.setBounds(520, 510, 110, 25);
        add(likeButton);
        
        JButton addCollectionButton = new JButton("Add Collection");
        addCollectionButton.setBounds(790, 510, 150, 25);
        add(addCollectionButton);
        
        JButton dislikeButton = new JButton("Dislike");
        dislikeButton.setBounds(655, 510, 110, 25);
        add(dislikeButton);
        
        JLabel outfitsTitle = new JLabel("Outfits");
        outfitsTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        outfitsTitle.setBounds(20, 41, 137, 15);
        add(outfitsTitle);
	}
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			System.out.println(outfits.getSelectedValue());
    		}
    	}
    };
}
