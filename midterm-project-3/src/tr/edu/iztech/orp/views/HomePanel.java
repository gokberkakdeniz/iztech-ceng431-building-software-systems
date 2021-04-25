package tr.edu.iztech.orp.views;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;

	public HomePanel() {
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(960, 720);

        JPanel container = new JPanel();
        FlowLayout flowLayout = (FlowLayout) container.getLayout();
        flowLayout.setAlignment(FlowLayout.LEADING);
        JPanel panelOne = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panelOne.getLayout();
        flowLayout_1.setAlignOnBaseline(true);
        flowLayout_1.setAlignment(FlowLayout.LEADING);
        JPanel panelTwo = new JPanel();
          
        String[] data = {"a", "b", "c", "d", "e", "f", "g"};
		JList<Object> list = new JList<Object>(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroller.setPreferredSize(new Dimension(400, 600));
		panelOne.add(listScroller);
        container.add(panelOne);
        container.add(panelTwo);
        
        JLabel lblNewLabel = new JLabel("New label");
        panelTwo.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        panelTwo.add(lblNewLabel_1);

        this.add(container, BorderLayout.WEST);

	}
}
