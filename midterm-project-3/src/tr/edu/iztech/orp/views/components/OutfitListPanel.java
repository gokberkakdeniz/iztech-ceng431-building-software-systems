package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.enums.OutfitRepositoryEvent;
import tr.edu.iztech.orp.models.AbstractOutfitContainer;
import tr.edu.iztech.orp.models.OutfitRepository;
import tr.edu.iztech.orp.utils.IObserver;

import javax.swing.event.ListSelectionEvent;

public class OutfitListPanel extends JPanel implements IObserver<OutfitRepository, OutfitRepositoryEvent> {
	private static final long serialVersionUID = -669290185768399715L;
	private JScrollPane outfitsScroller;
	private JList<Object> outfits;
	
	public OutfitListPanel() {
		this(null);
	}
	
	public OutfitListPanel(AbstractOutfitContainer<?, ?> model) {
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
                
        outfitsScroller = new JScrollPane();
        outfitsScroller.setBounds(0, 30, 300, 510);
        outfitsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outfitsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(outfitsScroller);

        outfits = new JList<Object>(model==null ? new String[] {"aa"} : model.getAll().toArray());
        outfits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        outfits.setVisibleRowCount(-1);
        
        outfitsScroller.setViewportView(outfits);
        
        JLabel outfitsTitle = new JLabel("Outfits");
        outfitsTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        outfitsTitle.setBounds(0, 0, 140, 15);
        add(outfitsTitle);
	}

	@Override
	public void update(OutfitRepositoryEvent event) {
		// do nothing
	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        outfits.addListSelectionListener(collectionChangeListener);
        outfits.setSelectedIndex(0);
	}
}
