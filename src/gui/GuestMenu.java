package gui;

import api.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestMenu extends JFrame implements ActionListener{
    private Guest guest;

    private JButton find,show,change,delete,signout;

      public GuestMenu(Guest guest){
          this.setVisible(true);
          this.setTitle("Guest Menu");
          this.setSize( 400, 400);
          this.setResizable(true);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          this.setLocationRelativeTo(null);
          this.setLayout(new FlowLayout());

          this.guest=guest;

          find=new JButton("FIND A ROOM");
          this.add(find);
          find.addActionListener(this);

          show=new JButton("SHOW YOUR REVIEWS");
          this.add(show);
          show.addActionListener(this);

          change=new JButton("CHANGE A REVIEW");
          this.add(change);
          change.addActionListener(this);

          delete=new JButton("DELETE A REVIEW");
          this.add(delete);
          delete.addActionListener(this);

          signout=new JButton("SIGN OUT");
          this.add(signout);
          signout.addActionListener(this);

      }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("FIND A ROOM")){
            this.dispose();
            FindRoomGuest p=new FindRoomGuest("Guest",guest);
        }
        else if(e.getActionCommand().equals("SHOW YOUR REVIEWS")){
            if (guest.getDates().keySet().size() == 0) {
                NoReview g=new NoReview();
            }
            else{
                this.dispose();
                ShowGuestReviews p = new ShowGuestReviews(guest);
            }
        }
        else if(e.getActionCommand().equals("CHANGE A REVIEW")){
            if (guest.getDates().keySet().size() == 0) {
                NoReview g=new NoReview();
            }
            else{
                this.dispose();
                ChangeorDeleteReview p=new ChangeorDeleteReview(guest,"Change review","c");
            }
        }
        else if(e.getActionCommand().equals("DELETE A REVIEW")){
            if (guest.getDates().keySet().size() == 0) {
                NoReview g=new NoReview();
            }
            else{
                this.dispose();
                ChangeorDeleteReview p=new ChangeorDeleteReview(guest,"Delete review","d");
            }
        }
        else if(e.getActionCommand().equals("SIGN OUT")){
            this.dispose();
            Start b=new Start();
        }
    }
}