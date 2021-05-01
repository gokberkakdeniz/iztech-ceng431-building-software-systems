package tr.edu.iztech.orp.views.components;

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

import tr.edu.iztech.orp.views.components.OutfitDetailPanel;

import javax.swing.event.ListSelectionEvent;

public class OutfitListPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JScrollPane outfitsScroller;
	private JList<Object> outfits;
	
	public OutfitListPanel() {
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
        
        String[] outfitArr = {"Outfit a", "Outfit sfaglk", "Outfit sgdlasf", "Outfit lkajsgfadfg", "Outfit klfsghnad", "Outfit sdklfgasgf"};
        
        outfitsScroller = new JScrollPane();
        outfitsScroller.setBounds(0, 30, 300, 510);
        outfitsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outfitsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(outfitsScroller);

        outfits = new JList<Object>(outfitArr);
        outfits.setSelectedIndex(0);
        outfits.addListSelectionListener(collectionChangeListener);
        outfits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        outfits.setVisibleRowCount(-1);
        
        outfitsScroller.setViewportView(outfits);
        
        JLabel outfitsTitle = new JLabel("Outfits");
        outfitsTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        outfitsTitle.setBounds(0, 0, 140, 15);
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
