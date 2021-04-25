package tr.edu.iztech.orp.views;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;

	public HomePanel() {
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
          
        String[] data = {"a", "b", "c", "d", "e", "f", "g"};
		JList<Object> list = new JList<Object>(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroller.setPreferredSize(new Dimension(120, 240));
		panelOne.add(listScroller);
        container.add(panelOne);
        container.add(panelTwo);

        this.add(container);

	}
}
