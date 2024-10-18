package gui;

import javax.swing.*;
import java.awt.*;



public class WrongInput extends JFrame {
    private JLabel wrong;
    public WrongInput(){
        this.setVisible(true);
        this.setTitle("WrongInput");
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        wrong=new JLabel("WRONG INPUT");
        this.add(wrong);
    }
}
