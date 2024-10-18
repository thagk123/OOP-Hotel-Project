package gui;

import javax.swing.*;
import java.awt.*;

public class NoReview extends JFrame {
    private JLabel label;

    public NoReview(){
        this.setVisible(true);
        this.setTitle("Guest Menu");
        this.setSize( 250, 200);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        label=new JLabel("Δεν βρέθηκε κάποια αξιολόγηση");
        this.add(label);
    }
}
