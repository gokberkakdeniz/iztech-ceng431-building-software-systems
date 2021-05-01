package tr.edu.iztech.orp.views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

public class FollowedUsersPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;

	public FollowedUsersPanel() {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        String[] data = {"a", "b", "c", "d", "e", "f", "g"};
        
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(20, 50, 200, 500);
        add(listScroller);
        listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> list = new JList<Object>(data);
        listScroller.setViewportView(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(-1);
        
        String[] data_2 = {"<html> ASDFASF: alksfjafsdgLKXSDC <br/> sşfdlkgasdgf", "SLKAJFAS: sgşlkjasfg", "DSLFKGDAGF: şlkdfgşlasdkgf", "ADŞGMFA: aşdflgag", "DFGADFG: asfgklasjg", "KLJDSGFHDS: kalfdjhafdg", "JASKLFGJASG: kdjfgsagf"};
            
        JScrollPane listScroller2 = new JScrollPane();
        listScroller2.setBounds(260, 50, 240, 500);
        add(listScroller2);
        listScroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> list2 = new JList<Object>(data_2);
        list2.setFixedCellHeight(40);
        listScroller2.setViewportView(list2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list2.setVisibleRowCount(-1);
        
        JButton btnNewButton_1 = new JButton("Unfollow");
        btnNewButton_1.setBounds(20, 562, 200, 25);
        add(btnNewButton_1);
        
        String[] data_3 = {"<html> ASDFASF: alksfjafsdgLKXSDC <br/> sşfdlkgasdgf", "SLKAJFAS: sgşlkjasfg", "DSLFKGDAGF: şlkdfgşlasdkgf", "ADŞGMFA: aşdflgag", "DFGADFG: asfgklasjg", "KLJDSGFHDS: kalfdjhafdg", "JASKLFGJASG: kdjfgsagf"};
        
        JScrollPane listScroller3 = new JScrollPane();
        listScroller3.setBounds(540, 50, 350, 500);
        add(listScroller3);
        listScroller3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JList<Object> list3 = new JList<Object>(data_3);
        list3.setFixedCellHeight(40);
        listScroller3.setViewportView(list3);
        list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list3.setVisibleRowCount(-1);
        
        JLabel lblUserListesi = new JLabel("USER LİSTESİ");
        lblUserListesi.setBounds(32, 26, 140, 15);
        add(lblUserListesi);
        
        JLabel lblCollectionListesi = new JLabel("COLLECTION LİSTESİ");
        lblCollectionListesi.setBounds(304, 26, 140, 15);
        add(lblCollectionListesi);
        
        JLabel lblOutfitListesi = new JLabel("OUTFIT LİSTESİ");
        lblOutfitListesi.setBounds(620, 23, 140, 15);
        add(lblOutfitListesi);

	}
}
