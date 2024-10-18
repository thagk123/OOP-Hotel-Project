package gui;

import javax.swing.*;
import java.awt.*;

public class Success extends JFrame {
    JLabel success;

    public Success() {
        this.setVisible(true);
        this.setTitle("The changes were made successfully");
        this.setSize(600, 600);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        success = new JLabel("The changes were made successfully");
        this.add(success);
    }
}