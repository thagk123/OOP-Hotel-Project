package gui;

import api.Guest;
import api.Room;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Set;

public class ShowGuestReviews extends JFrame implements ActionListener{
    private Guest guest;
    private ArrayList<Room> rooms;
    private JTextField find;

    public ShowGuestReviews(Guest guest){
        this.setVisible(true);
        this.setTitle("Show your reviews");
        this.setSize( 700, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.guest=guest;

        GridLayout grid=new GridLayout(numb()+4,0);
        this.setLayout(grid);

        this.rooms=new ArrayList<>();

        JPanel panel1=new JPanel();
        this.add(panel1);
        JLabel mnm1=new JLabel("Παρακάτω εμφανίζονται τα καταλύματα που έχετε αξιολογήσει");
        panel1.add(mnm1);
        continueFrame();
    }

    public int numb(){
       Set k=guest.getDates().keySet();
       return k.size();
    }

    public void continueFrame(){
        Set k=guest.getDates().keySet();
        ArrayList<Room> R=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Rooms.bin"))){
            R=(ArrayList<Room>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(Room r:R){
            if(k.contains(r.getName())){
                rooms.add(r);
            }
        }

        int pl=k.size();
        int num=0;
        for (Room a:rooms) {
            JPanel panel=new JPanel();
            this.add(panel);
            JLabel mnm=new JLabel(a.getName()+" "+a.getType()+" "+a.getCity()+" "+a.getStars().get(guest.getUsername()));
            panel.add(mnm);
            num=num+a.getStars().get(guest.getUsername());
        }

        JPanel panel3=new JPanel();
        this.add(panel3);
        JLabel l=new JLabel("Ο μέσος όρος της βαθμολογίας που έχετε δώσει συνολικά στα καταλύματα που έχετε αξιολογήσει είναι "+num/(float) pl);
        panel3.add(l);

        JPanel panel4=new JPanel();
        this.add(panel4);
        JLabel room=new JLabel("Συμπληρώστε το όνομα του ξενοδοχείου που θέλετε να ψάξετε: ");
        panel4.add(room);
        find=new JTextField(12);
        panel4.add(find);
        JButton fn=new JButton("FIND");
        panel4.add(fn);
        fn.addActionListener(this);
        JPanel panel5=new JPanel();
        this.add(panel5);
        JButton but=new JButton("Back to Menu");
        panel5.add(but);
        but.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back to Menu")){
            ArrayList<Guest> guests=new ArrayList<>();
            try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Guests.bin"))){
                guests=(ArrayList<Guest>) in.readObject();
            }   catch(IOException k){
                k.printStackTrace();
            } catch (ClassNotFoundException k) {
                throw new RuntimeException(k);
            }

            for (Guest b:guests) {
                if (b.getUsername().equals(guest.getUsername())){
                    this.dispose();
                    GuestMenu c=new GuestMenu(b);
                    break;
                }
            }
        }
        else{
            boolean flag=false;
            for (Room k : rooms) {
                if (k.getName().equals(find.getText())) {
                    this.dispose();
                    ShowRoom b = new ShowRoom("Guest", k, guest.getUsername());
                    flag=true;
                    break;
                }
            }
            if(!flag){
                NoRoom q=new NoRoom();
            }
        }
    }
}
