package gui;

import javax.swing.*;
import java.awt.*;

public class NoRoom extends JFrame {
    private JLabel label;

    public NoRoom(){
        this.setVisible(true);
        this.setTitle("Guest Menu");
        this.setSize( 250, 200);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        label=new JLabel("Δεν βρέθηκε ξενοδοχείο");
        this.add(label);
    }
}