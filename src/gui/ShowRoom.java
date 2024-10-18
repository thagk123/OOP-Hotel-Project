package gui;

import api.Guest;
import api.Provider;
import api.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ShowRoom extends JFrame implements  ActionListener{
    private String user,username;
    private Room room;
    private JLabel name,type,dief,city,tnumber,description;
    private JButton change,delete,add,show,back;

    private JPanel panel1,panel2,panel3;
    public ShowRoom(String user,Room room,String username){
        this.setVisible(true);
        this.setTitle("Show a room");
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout grid=new GridLayout(9,0);
        this.setLayout(grid);

        this.user=user;
        this.room=room;
        this.username=username;

        this.add(name=new JLabel("Hotel Name: "+room.getName()));
        this.add(type=new JLabel("Type: "+room.getType()));
        this.add(dief=new JLabel("Address: "+room.getDief()));
        this.add(city=new JLabel("City: "+room.getCity()));
        this.add(tnumber=new JLabel("Tnumber: "+room.getTnumber()));
        this.add(description=new JLabel(room.getDescription()));
        panel1=new JPanel();
        this.add(panel1);
        JLabel k=new JLabel("Παροχές: ");
        panel1.add(k);
        for (String a: room.getParoxes()) {
            JLabel i=new JLabel(a);
            panel1.add(i);
        }
        panel2=new JPanel();
        this.add(panel2);
        show=new JButton("Show reviews");
        show.addActionListener(this);
        panel2.add(show);
        panel3=new JPanel();
        this.add(panel3);
        if (user.equals("Provider")){
            change=new JButton("Change Room");
            delete= new JButton("Delete Room");
            change.addActionListener(this);
            delete.addActionListener(this);
            panel3.add(change);
            panel3.add(delete);
        }
        if (user.equals("Guest")) {
            add = new JButton("Add review");
            add.addActionListener(this);
            panel3.add(add);
            back = new JButton("Back to Menu");
            back.addActionListener(this);
            panel3.add(back);
        }
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getActionCommand().equals("Show reviews")){
            ShowReviews b=new ShowReviews(room);
        }
        else if(a.getActionCommand().equals("Add review")){
            this.dispose();
            AddReview c=new AddReview(room,username);
        }
        else if(a.getActionCommand().equals("Change Room")){
            this.dispose();
            ChangeRoom c=new ChangeRoom(room,username);
        }
        else if(a.getActionCommand().equals("Back to Menu")){
            ArrayList<Guest> guests=new ArrayList<>();
            try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Guests.bin"))){
                guests=(ArrayList<Guest>) in.readObject();
            }   catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            for (Guest b:guests) {
                if (b.getUsername().equals(username)){
                    this.dispose();
                    GuestMenu c=new GuestMenu(b);
                    break;
                }
            }
        }
        else if(a.getActionCommand().equals("Delete Room")){
            ArrayList<Room> R=new ArrayList<>();
            try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Rooms.bin"))){
                R=(ArrayList<Room>) in.readObject();
            }   catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            int pl=0;
            for(Room r:R){
                if(r.getName().equals(room.getName())){
                    break;
                }
                pl++;
            }
            R.remove(pl);

            Path a1= Paths.get("Rooms.bin");
            try{
                Files.delete(a1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
                out.writeObject(R);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<Provider> P=new ArrayList<>();
            try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Providers.bin"))){
                P=(ArrayList<Provider>) in.readObject();
            }   catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            int pq=0;
            for(Provider pro:P){
                if(pro.getUsername().equals(room.getProvider().getUsername())){
                    break;
                }
                pq++;
            }
            P.remove(pq);
            room.getProvider().deleteRoom(room);
            P.add(room.getProvider());

            Path a2= Paths.get("Providers.bin");
            try{
                Files.delete(a2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Providers.bin"))) {
                out.writeObject(P);
            } catch (IOException e) {
                e.printStackTrace();
            }


            this.dispose();
            ProviderMenu pm=new ProviderMenu(room.getProvider());
        }
    }

}
