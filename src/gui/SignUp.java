package gui;

import api.Guest;
import api.Provider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;

public class SignUp extends JFrame implements ActionListener {
    private JTextField name,surname,username;
    private JRadioButton prov,gues;
    private JPasswordField password;
    private JButton login;
    private JLabel na,sur,user,typ,pass;
    public SignUp() {

        this.setVisible(true);
        this.setTitle("Sign Up page");
        this.setSize(500, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        na=new JLabel("Name");
        this.add(na);

        name=new JTextField(13);
        this.add(name);

        sur=new JLabel("Last Name");
        this.add(sur);

        surname=new JTextField(13);
        this.add(surname);

        user=new JLabel("UserName");
        this.add(user);

        username=new JTextField(12);
        this.add(username);

        pass=new JLabel("Password");
        this.add(pass);

        password=new JPasswordField(12);
        this.add(password);

        typ=new JLabel("Type");
        this.add(typ);

        prov=new JRadioButton("Provider");
        this.add(prov);
        gues=new JRadioButton("Guest");
        this.add(gues);
        ButtonGroup group=new ButtonGroup();
        group.add(prov);
        group.add(gues);
        prov.setSelected(true);

        login=new JButton("SignUp");
        this.add(login);
        login.addActionListener(this);


    }

    public void actionPerformed(ActionEvent a) {

        ArrayList<Provider> P=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Providers.bin"))){
            P=(ArrayList<Provider>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Guest> G=new ArrayList<>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("Guests.bin"))){
            G=(ArrayList<Guest>) in.readObject();
        }   catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        boolean flag=true;
        for(Provider p:P){
            if(p.getUsername().equals(username.getText())){
                flag=false;
            }
        }
        for(Guest g:G){
            if(g.getUsername().equals(username.getText())){
                flag=false;
            }
        }

        if((name.getText().isEmpty())||(surname.getText().isEmpty())||(username.getText().isEmpty())||(password.getText().isEmpty())||(flag==false)){
            WrongInput w=new WrongInput();
        }
        else{
            if(prov.isSelected()){

                Provider p=new Provider(name.getText(),surname.getText(),username.getText(),password.getText(),"Provider");
                P.add(p);
                Path a1=Paths.get("Providers.bin");
                try{
                    Files.delete(a1);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Providers.bin"))) {
                    out.writeObject(P);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.dispose();
                ProviderMenu pm=new ProviderMenu(p);
            }
            else{
                Guest g=new Guest(name.getText(),surname.getText(),username.getText(),password.getText(),"Guest");
                G.add(g);
                Path a1=Paths.get("Guests.bin");
                try{
                    Files.delete(a1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin"))) {
                    out.writeObject(G);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.dispose();
                GuestMenu gm=new GuestMenu(g);
            }
        }
    }




    }