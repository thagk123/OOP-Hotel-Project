package gui;

import api.Room;
import api.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowSearchRooms extends JFrame implements ActionListener{
    private ArrayList<Room> rooms;
    private String type;
    private Guest guest;
    private JTextField find;

    public ShowSearchRooms(ArrayList<Room> rooms,String type,Guest guest){
        this.setVisible(true);
        this.setTitle("Find a room");
        this.setSize( 700, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.rooms=rooms;
        GridLayout grid=new GridLayout(rooms.size()+3,0);
        this.setLayout(grid);

        this.type=type;
        this.guest=guest;

        JPanel panel1=new JPanel();
        this.add(panel1);
        JLabel mnm1=new JLabel("Παρακάτω εμφανίζονται τα ξενοδοχεία που ταιριάζουν στις επιλογές σας");
        panel1.add(mnm1);
        for (Room c:rooms) {
            JPanel panel=new JPanel();
            this.add(panel);
            int num=0;
            for (Integer b:c.getStars().values()) {
                num=num+b;
            }
            JLabel lab=new JLabel(c.getName()+" "+c.getType()+" "+c.getCity()+" "+num/(float) c.getStars().keySet().size());
            panel.add(lab);
        }
        JPanel panel2=new JPanel();
        this.add(panel2);
        JLabel mnm=new JLabel("Συμπληρώστε το όνομα του ξενοδοχείου");
        panel2.add(mnm);
        find=new JTextField(20);
        panel2.add(find);
        JButton findd=new JButton("FIND ROOM");
        panel2.add(findd);
        findd.addActionListener(this);
        JPanel panel3=new JPanel();
        this.add(panel3);
        JButton back=new JButton("Back to Menu");
        panel3.add(back);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getActionCommand().equals("Back to Menu")){
            this.dispose();
            GuestMenu g=new GuestMenu(guest);
        }
        else{
            boolean flag=false;
            for (Room k:rooms) {
                if (k.getName().equals(find.getText())){
                    this.dispose();
                    ShowRoom i=new ShowRoom("Guest",k,guest.getUsername());
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                NoRoom g = new NoRoom();
            }
        }
    }

}
