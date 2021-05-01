package tr.edu.iztech.orp.views;

import javax.swing.JPanel;
import tr.edu.iztech.orp.views.components.*;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	public HomePanel() {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);

        JPanel outfitList = new OutfitListPanel();
        outfitList.setBounds(5, 20, 340, 665);
        add(outfitList);
        
        JPanel outfitDetail = new OutfitDetailPanel(this);
        outfitDetail.setBounds(520, 0, 440, 685);
		add(outfitDetail);

	}

}
