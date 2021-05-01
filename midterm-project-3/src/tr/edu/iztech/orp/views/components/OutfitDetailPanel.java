package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import tr.edu.iztech.orp.views.HomePanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OutfitDetailPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	public OutfitDetailPanel(JPanel homePanel) {
        setSize(420, 685);
        setLayout(null);
        setVisible(true);
                
        String[] commentArr = {"User a: alksfjafsdgLKXSDC", "User b: sgşlkjasfg", "User c: şlkdfgşlasdkgf", 
        		"User d: aşdflgag", "User e: asfgklasjg", "User f: kalfdjhafdg", "User g: kdjfgsagf"};
        
        JScrollPane commentsScroller = new JScrollPane();
        commentsScroller.setBounds(0, 150, 420, 350);
        add(commentsScroller);
        commentsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> comments = new JList<Object>(commentArr);
        comments.setFixedCellHeight(20);
        commentsScroller.setViewportView(comments);
        comments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        comments.setVisibleRowCount(-1);
        
        JLabel idLabel = new JLabel("Id: 3526");
        idLabel.setBounds(0, 30, 129, 15);
        add(idLabel);
        
        JLabel brandLabel = new JLabel("Brand: LC Waisiki");
        brandLabel.setBounds(160, 30, 129, 15);
        add(brandLabel);
        
        JLabel clothingTypeLabel = new JLabel("Type: Tshirt");
        clothingTypeLabel.setBounds(300, 60, 129, 15);
        add(clothingTypeLabel);
        
        JLabel occassionLabel = new JLabel("Ocassion: Party, Elegant");
        occassionLabel.setBounds(0, 60, 129, 15);
        add(occassionLabel);
        
        JLabel genderLabel = new JLabel("Gender: Female");
        genderLabel.setBounds(160, 60, 129, 15);
        add(genderLabel);
        
        JLabel sizeLabel = new JLabel("Sizes: XL, XXL");
        sizeLabel.setBounds(0, 90, 129, 15);
        add(sizeLabel);
        
        JLabel colorLabel = new JLabel("Colors: Red, White");
        colorLabel.setBounds(160, 90, 180, 15);
        add(colorLabel);
        
        JLabel likeCountLabel = new JLabel("Likes: 169");
        likeCountLabel.setBounds(0, 125, 129, 15);
        add(likeCountLabel);
        
        JLabel dislikeCountLabel = new JLabel("Dislikes: 31");
        dislikeCountLabel.setBounds(100, 125, 129, 15);
        add(dislikeCountLabel);
        
        JButton sendButton = new JButton("Send");
        sendButton.setBounds(310, 602, 110, 25);
        add(sendButton);
        
        JTextArea commentField = new JTextArea();
        commentField.setBounds(0, 550, 420, 40);
        commentField.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        add(commentField);
        
        JButton likeButton = new JButton("Like");
        likeButton.setBounds(0, 510, 110, 25);
        add(likeButton);
                
        JButton addCollectionButton = new JButton("Add Collection");
        addCollectionButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Object[] possibilities = {"Collection A", "Collection B", "Collection C", "Collection E"};
        		JOptionPane.showInputDialog(
                    homePanel,
                    "Please Choose collection to add",
                    "Add to Collection",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    null);
        	}
        });
        
        addCollectionButton.setBounds(270, 510, 150, 25);
        add(addCollectionButton);
        
        JButton dislikeButton = new JButton("Dislike");
        dislikeButton.setBounds(135, 510, 110, 25);
        add(dislikeButton);
        
	}

}
