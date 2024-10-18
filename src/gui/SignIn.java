package gui;

import api.Guest;
import api.Provider;
import api.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SignIn extends JFrame implements ActionListener{
    private JButton login;
    private JTextField username;
    private JLabel label,password1;
    private JPasswordField Password;
    public SignIn(){

        this.setVisible(true);
        this.setTitle("Sign In");
        this.setSize( 500, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());


        label = new JLabel("Username");
        this.add(label);


        username=new JTextField(10);

        this.add(username);

        password1=new JLabel("Password");
        this.add(password1);

        Password = new JPasswordField(10);

        this.add(Password);

        login=new JButton("SignIn");
        login.addActionListener(this);
        this.add(login);

    }


    @Override
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

        boolean flag=false;
        for(Provider p:P){
            if((p.getUsername().equals(username.getText()))&&(p.getPassword().equals(Password.getText()))) {
                this.dispose();
                ProviderMenu pm = new ProviderMenu(p);
                flag = true;
            }
        }
        if(flag==false) {
            for (Guest g : G) {
                if ((g.getUsername().equals(username.getText())) && (g.getPassword().equals(Password.getText()))) {
                    this.dispose();
                    GuestMenu pm = new GuestMenu(g);
                    flag = true;
                }

            }
        }


        if((username.getText().isEmpty())||(Password.getText().isEmpty())||(!flag)){
            WrongInput w=new WrongInput();
        }
    }


}



