package tr.edu.iztech.orp.views.screens;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.utils.IObserver;
import tr.edu.iztech.orp.views.components.*;

public class HomePanel extends JPanel implements IObserver<OutfitRepository, OutfitRepositoryEvent> {
	private static final long serialVersionUID = -669290185768399715L;
	private OutfitListPanel<OutfitRepository, OutfitRepositoryEvent> outfitList;
	private OutfitDetailPanel outfitDetail;
	
	public HomePanel(OutfitRepository model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
		outfitList = new OutfitListPanel<>(model);
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

	@Override
	public void update(OutfitRepositoryEvent event) {
		// do nothing
	}
}
