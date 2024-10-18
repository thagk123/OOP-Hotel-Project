package gui;

import api.Room;
import api.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddReview extends JFrame implements ActionListener{
   private Guest guest;
   private String username;
   private JTextField keimeno,hm,asteria;
   private Room room;

    public AddReview(Room room,String username){
        this.setVisible(true);
        this.setTitle("Add Review");
        this.setSize( 600, 300);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        this.room=room;
        this.username=username;
        this.guest=findGuest();
        continueFrame();

    }

    public Guest findGuest(){
        ArrayList<Guest> G=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Guests.bin"))){
            G=(ArrayList<Guest>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Guest guest:G) {
            if (guest.getUsername().equals(username)){
                return guest;
            }
        }
        return null;
    }

    public void continueFrame(){
        JPanel panel1=new JPanel();
        this.add(panel1);
        JLabel mnm1=new JLabel("Κείμενο αξιολόγησης (500 χαρακτήρες μέγιστο):");
        keimeno=new JTextField();
        keimeno.setPreferredSize(new Dimension(250,50));
        panel1.add(mnm1);
        panel1.add(keimeno);
        JPanel panel2=new JPanel();
        this.add(panel2);
        JLabel mnm2=new JLabel("Βαθμολογία (απο 0 εως 5 αστέρια): ");
        asteria=new JTextField(2);
        panel2.add(mnm2);
        panel2.add(asteria);
        JPanel panel3=new JPanel();
        this.add(panel3);
        JLabel mnm3=new JLabel("Εισάγετε ημερομηνία (π.χ. 1/1/2022):");
        hm=new JTextField(12);
        panel3.add(mnm3);
        panel3.add(hm);
        JButton add=new JButton("Add review");
        this.add(add);
        add.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        boolean flag=false;
        if (asteria.getText().equals("") || asteria.getText().length()>1){
            flag=true;
            WrongInput r=new WrongInput();
        }
        if(!flag) {
            if (keimeno.getText().length() > 500 || keimeno.getText().equals("") || Integer.parseInt(asteria.getText()) < 0 || Integer.parseInt(asteria.getText()) > 5 || hm.getText().equals("")) {
                WrongInput r = new WrongInput();
            } else {
                ArrayList<Room> rooms = new ArrayList<>();
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Rooms.bin"))) {
                    rooms = (ArrayList<Room>) in.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                for (Room e : rooms) {
                    if (e.getName().equals(room.getName())) {
                        e.addreview(username, keimeno.getText(), Integer.parseInt(asteria.getText()), hm.getText());
                    }
                }

                Path a1 = Paths.get("Rooms.bin");
                try {
                    Files.delete(a1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
                    out.writeObject(rooms);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<Guest> guests = new ArrayList<>();
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Guests.bin"))) {
                    guests = (ArrayList<Guest>) in.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                for (Guest b : guests) {
                    if (b.getUsername().equals(username)) {
                        b.addReview(room.getName(), keimeno.getText(), Integer.parseInt(asteria.getText()), hm.getText());
                        this.guest = b;
                    }
                }

                Path a2 = Paths.get("Guests.bin");
                try {
                    Files.delete(a2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin"))) {
                    out.writeObject(guests);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                this.dispose();
                GuestMenu o = new GuestMenu(guest);
            }
        }
        }

}
