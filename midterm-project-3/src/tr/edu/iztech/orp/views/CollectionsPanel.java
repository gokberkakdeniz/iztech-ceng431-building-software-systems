package tr.edu.iztech.orp.views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CollectionsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private JTextField txtXvbgdvc;

	public CollectionsPanel() {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        String[] data = {"a", "b", "c", "d", "e", "f", "g"};
        
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(20, 50, 300, 500);
        add(listScroller);
        listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> list = new JList<Object>(data);
        listScroller.setViewportView(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(-1);
        
        String[] data_2 = {"<html> ASDFASF: alksfjafsdgLKXSDC <br/> sşfdlkgasdgf", "SLKAJFAS: sgşlkjasfg", "DSLFKGDAGF: şlkdfgşlasdkgf", "ADŞGMFA: aşdflgag", "DFGADFG: asfgklasjg", "KLJDSGFHDS: kalfdjhafdg", "JASKLFGJASG: kdjfgsagf"};
        
        
        JScrollPane listScroller2 = new JScrollPane();
        listScroller2.setBounds(480, 50, 420, 500);
        add(listScroller2);
        listScroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> list2 = new JList<Object>(data_2);
        list2.setFixedCellHeight(40);
        listScroller2.setViewportView(list2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list2.setVisibleRowCount(-1);
        
        txtXvbgdvc = new JTextField();
        txtXvbgdvc.setBounds(20, 568, 183, 19);
        add(txtXvbgdvc);
        txtXvbgdvc.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Create");
        btnNewButton_1.setBounds(215, 562, 107, 25);
        add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Remove Item From Collection");
        btnNewButton.setBounds(480, 565, 420, 25);
        add(btnNewButton);
        
        JLabel lblUserListesi = new JLabel("USER LİSTESİ");
        lblUserListesi.setBounds(75, 23, 140, 15);
        add(lblUserListesi);
        
        JLabel lblCollectionListesi = new JLabel("COLLECTION LİSTESİ");
        lblCollectionListesi.setBounds(615, 23, 140, 15);
        add(lblCollectionListesi);

	}
}
