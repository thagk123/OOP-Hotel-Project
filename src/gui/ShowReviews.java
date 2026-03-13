package gui;

import api.Room;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ShowReviews extends JFrame{

    public ShowReviews(Room room){
        this.setVisible(true);
        this.setTitle("Reviews");
        this.setSize( 600, 200);
        this.setResizable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Map<String,String> allreviews=room.getReviews();
        Map<String,Integer> allstars=room.getStars();
        Map<String,String> alldates=room.getDate();

        GridLayout grid=new GridLayout(allreviews.keySet().size()+2,0);
        this.setLayout(grid);

        float meanAverage = findMeanAverage(allstars);
        continueFrame(meanAverage, alldates, allreviews, allstars);
    }

    private float findMeanAverage(Map<String,Integer> allstars){
        int stars=0;
        for (Integer star:allstars.values()) {
            stars=stars+star;
        }
        return stars/(float) allstars.keySet().size();
    }

    private void continueFrame(float mo, Map<String,String> alldates, Map<String,String> allreviews, Map<String,Integer> allstars){
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
