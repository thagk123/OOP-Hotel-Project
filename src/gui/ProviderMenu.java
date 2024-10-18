package gui;

import api.Provider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProviderMenu extends JFrame implements ActionListener {
    JButton add,rooms,signout;
    Provider prov;

    public ProviderMenu(Provider prov){
        this.setVisible(true);
        this.setTitle("Provider Menu");
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        this.prov=prov;

        add=new JButton("ADD ROOM");
        this.add(add);
        add.addActionListener(this);


        rooms=new JButton("YOUR ROOMS");
        this.add(rooms);
        rooms.addActionListener(this);

        signout=new JButton("SIGN OUT");
        this.add(signout);
        signout.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ADD ROOM")){
            this.dispose();
            AddRoom p=new AddRoom(prov);
        }
        else if(e.getActionCommand().equals("YOUR ROOMS")){
            this.dispose();
            YourRooms p=new YourRooms(prov);
        }
        else if(e.getActionCommand().equals("SIGN OUT")){
            this.dispose();
            Start p=new Start();
        }


    }
}
