package gui;

import api.Guest;
import api.Room;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ChangeorDeleteReview extends JFrame implements ActionListener{
    private Guest guest,guest2;
    private JTextField text;
    private Room room;
    private String s1,s2;

    public ChangeorDeleteReview(Guest guest,String s1,String s2){
        this.setVisible(true);
        this.s1=s1;
        this.s2=s2;
        this.setTitle(s1);
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout grid=new GridLayout(2,1);
        this.setLayout(grid);

        this.guest=guest;

        JPanel panel= new JPanel();
        this.add(panel);
        JLabel mnm=new JLabel("Συμπληρώστε το όνομα του ξενοδοχείου");
        panel.add(mnm);
        text=new JTextField(20);
        panel.add(text);
        JPanel panel2= new JPanel();
        this.add(panel2);
        JButton delete=new JButton(s1);
        panel2.add(delete);
        delete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        ArrayList<Room> rooms=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Rooms.bin"))){
            rooms=(ArrayList<Room>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        boolean flag1=false;
        for (Room r:rooms) {
            if (r.getName().equals(text.getText())){
                r.removereview(guest.getUsername());
                this.room=r;
                flag1=true;
                break;
            }
        }

        Path a1= Paths.get("Rooms.bin");
        try{
            Files.delete(a1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
            out.writeObject(rooms);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Guest> guests=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Guests.bin"))){
            guests=(ArrayList<Guest>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(flag1){
            for (Guest b:guests) {
                if (b.getUsername().equals(guest.getUsername())){
                    b.removeReview(room.getName());
                    this.guest2=b;
                    flag1=true;
                    break;
                }
            }
        }

        Path a2= Paths.get("Guests.bin");
        try{
            Files.delete(a2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin"))) {
            out.writeObject(guests);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!flag1) {
            NoRoom g=new NoRoom();
        }
        else{
            if (s2.equals("c")){
                this.dispose();
                AddReview g=new AddReview(room,guest2.getUsername());
            }
            else if (s2.equals("d")){
                this.dispose();
                GuestMenu o=new GuestMenu(guest2);
            }
        }
    }
}
