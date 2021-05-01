package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import tr.edu.iztech.orp.views.components.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StatisticsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	public StatisticsPanel() {
        setSize(960, 685);
        setLayout(null);
        
        JLabel mostLikedLabel = new JLabel("The Most Liked Outfit: ŞSDLAFDASF");
        mostLikedLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostLikedLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostLikedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostLikedLabel.setBounds(0, 160, 960, 45);
        add(mostLikedLabel);
        
        JLabel mostDislikedLabel = new JLabel("The Most Disliked Outfit: ZFHDGFHSD");
        mostDislikedLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostDislikedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostDislikedLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostDislikedLabel.setBounds(0, 245, 960, 45);
        add(mostDislikedLabel);
        
        JLabel mostFollowedUserLabel = new JLabel("The Most Followed User: User Darius Alp");
        mostFollowedUserLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostFollowedUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostFollowedUserLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostFollowedUserLabel.setBounds(0, 330, 960, 45);
        add(mostFollowedUserLabel);
        setVisible(true);

       

	}
}
