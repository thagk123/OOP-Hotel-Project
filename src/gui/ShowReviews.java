package gui;

import api.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.util.HashMap;

public class ShowReviews extends JFrame{

    private Room room;
    private HashMap<String,String> allreviews;
    private HashMap<String,Integer> allstars;
    private HashMap<String,String> alldates;

    public ShowReviews(Room room){
        this.setVisible(true);
        this.setTitle("Reviews");
        this.setSize( 600, 200);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.room=room;
        this.allreviews=room.getReviews();
        this.allstars=room.getStars();
        this.alldates=room.getDate();

        GridLayout grid=new GridLayout(allreviews.keySet().size()+2,0);
        this.setLayout(grid);

        continueFrame(find_MO());
    }

    public float find_MO(){
        int stars=0;
        for (Integer star:allstars.values()) {
            stars=stars+star;
        }
        float mo=stars/(float) allstars.keySet().size();
        return mo;
    }

    public void continueFrame(float mo){
        FlowLayout layout=new FlowLayout();
        layout.setAlignment(FlowLayout.LEADING);
        JPanel panel1=new JPanel(layout);
        this.add(panel1);
        JLabel first=new JLabel("Έγιναν "+allstars.keySet().size()+" αξιολογήσεις με μέσο όρο "+mo+" αστέρια.");
        panel1.add(first);
        this.add(first);
        for (String a:allstars.keySet()) {
            JPanel panel=new JPanel(layout);
            this.add(panel);
            JLabel b1=new JLabel(a+": "+allreviews.get(a)+". Βαθμολογία: "+allstars.get(a)+" αστέρια. "+alldates.get(allreviews.get(a)));
            panel.add(b1);
        }
    }

}
