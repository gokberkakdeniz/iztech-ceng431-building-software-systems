package tr.edu.iztech.orp.views.screens;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.views.components.*;

/**
 * This view shows outfit list at the left, outfit details at the right.
 * 
 * Behavior:
 * - When user selected outfit from the list, outfit details will show up on the right.
 *   User can like/dislike, remove like/dislike, comment.
 * 
 * Children:
 * 	- OutfitRepositoryListPanel
 *	- OutfitDetailPanel
 */
public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private OutfitRepositoryListPanel outfitList;
	private OutfitDetailPanel outfitDetail;
	
	public HomePanel(OutfitRepository model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
		outfitList = new OutfitRepositoryListPanel(model);
        outfitList.setBounds(5, 20, 340, 665);
        add(outfitList);
    }
	
	public void setOutfitDetailPanel(OutfitDetailPanel outfitDetail) {
		if (this.outfitDetail != null) remove(this.outfitDetail);
		
		if (outfitDetail != null) {
			this.outfitDetail = outfitDetail;
			this.outfitDetail.setBounds(520, 0, 440, 685);
	        add(this.outfitDetail);
		}

		repaint();
		revalidate();
	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        outfitList.addListSelectionListener(collectionChangeListener);
	}

	public void addLikeButtonListener(ActionListener listener) {
		outfitDetail.addLikeButtonListener(listener);
	}
	
	public void addDislikeButtonListener(ActionListener listener) {
		outfitDetail.addDislikeButtonListener(listener);
	}
}
