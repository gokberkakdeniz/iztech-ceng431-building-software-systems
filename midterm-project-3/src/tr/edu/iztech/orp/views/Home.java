package tr.edu.iztech.orp.views;

import javax.swing.*;

public class Home {
    private JPanel homePanel;
    private JComboBox navbarCombo;
    private JLabel applicationNameLabel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Home Screen");
        frame.setContentPane(new Home().homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
