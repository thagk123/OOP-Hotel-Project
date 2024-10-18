package gui;

import api.Provider;
import api.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class YourRooms extends JFrame implements ActionListener {
    Provider prov;
    JPanel panel1,panel2,panel3;
    Integer pl;
    Float sum;
    JTextField find;
    JLabel room;
    JButton fn;

    JLabel emfanisi,emfanisi2;
    public YourRooms(Provider prov){
        this.prov=prov;
        this.setVisible(true);
        this.setTitle("Your Rooms");
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        ArrayList<Room> R=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Rooms.bin"))){
            R=(ArrayList<Room>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Room> Ro=new ArrayList<>();
        for(Room r:R){
            if(r.getProvider().getUsername().equals(prov.getUsername())){
                Ro.add(r);
            }
        }
        int p=0,stars=0;
        HashMap<String,String> H;
        HashMap<String,Integer> Hr;
        for(Room r:Ro){
            H=r.getReviews();
            Hr=r.getStars();
            p+=H.keySet().size();
            for(Integer star:Hr.values()){
                stars+=star;
            }
        }
        this.pl=p;
        this.sum=(float)stars/this.pl;

        panel1=new JPanel();

        this.add(panel1);
        emfanisi=new JLabel("Έγιναν "+pl+" αξιολογήσεις στα δωμάτια και έχουν μέσο όρο "+sum+" αστέρια");
        panel1.add(emfanisi);

        for(Room r:Ro){
            stars=0;
            panel2=new JPanel();
            this.add(panel2);
            Hr=r.getStars();
            p=Hr.keySet().size();
            for(Integer star:Hr.values()){
                stars+=star;
            }

            emfanisi2=new JLabel("Name: "+r.getName()+" Type: "+r.getType()+" City: "+r.getCity()+" Average stars: "+(float)stars/p);
            panel2.add(emfanisi2);
        }
        panel3=new JPanel();
        this.add(panel3);
        room=new JLabel("Type the name of a room");
        panel3.add(room);
        find=new JTextField(12);
        panel3.add(find);
        fn=new JButton("FIND");
        this.add(fn);
        fn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        ArrayList<Room> R=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Rooms.bin"))){
            R=(ArrayList<Room>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Room> Ro=new ArrayList<>();
        for(Room r:R){
            if(r.getProvider().getUsername().equals(prov.getUsername())){
                Ro.add(r);
            }
        }
       boolean flag=false;
        if(a.getActionCommand().equals("FIND")){
            for(Room r:Ro){
                if(r.getName().equals(find.getText())){
                    this.dispose();
                    ShowRoom g=new ShowRoom("Provider",r,prov.getUsername());
                    flag=true;
                }

            }
            if(flag==false){
                WrongInput w=new WrongInput();
            }
        }



    }
}
