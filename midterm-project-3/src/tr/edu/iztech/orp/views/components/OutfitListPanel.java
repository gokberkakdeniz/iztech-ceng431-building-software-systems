package tr.edu.iztech.orp.views.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import tr.edu.iztech.orp.models.AbstractOutfitContainer;
import tr.edu.iztech.orp.models.Outfit;
import tr.edu.iztech.orp.utils.IEvent;
import tr.edu.iztech.orp.utils.IObserver;

/**
 * Generic outfit list panel for both outfit collection and outfit repository.
 *
 * @param <T> model
 * @param <K> model event
 */
public abstract class OutfitListPanel<T, K extends IEvent<T>> extends JPanel implements IObserver<T, K> {
	private static final long serialVersionUID = -669290185768399715L;
	
	protected JScrollPane outfitsScroller;
	protected JList<Object> outfits;
	protected AbstractOutfitContainer<T, K> model;
	
	public OutfitListPanel(AbstractOutfitContainer<T, K> model) {
		this.model = model;
		
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
                       
        outfitsScroller = new JScrollPane();
        outfitsScroller.setBounds(0, 30, 300, 510);
        outfitsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outfitsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(outfitsScroller);

        outfits = new JList<Object>(model.getAll().toArray());
        outfits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        outfits.setVisibleRowCount(-1);
        
        outfitsScroller.setViewportView(outfits);
        
        JLabel outfitsTitle = new JLabel("Outfits");
        outfitsTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        outfitsTitle.setBounds(0, 0, 140, 15);
        add(outfitsTitle);
	}

	public Outfit getSelection() {
		return (Outfit) outfits.getSelectedValue();
	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        outfits.addListSelectionListener(collectionChangeListener);
        outfits.setSelectedIndex(0);
	}
}
