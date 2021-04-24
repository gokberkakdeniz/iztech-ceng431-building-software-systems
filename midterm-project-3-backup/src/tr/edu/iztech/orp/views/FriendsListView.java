package tr.edu.iztech.orp.views;

import javax.swing.*;

public class FriendsListView {
    private JPanel friendsListPanel;
    private JComboBox comboBox1;
    private JList list1;
    private JList list2;
    private JButton followButton;
    private JButton unfollowButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Followed Users Screen");
        frame.setContentPane(new FriendsListView().friendsListPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
