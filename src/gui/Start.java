package gui;


import api.Provider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start extends JFrame implements ActionListener {
    private JButton signin;
    private JButton signup;


    public Start(){


        this.setVisible(true);
        this.setTitle("Welcome");
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        signin=new JButton("Sign in");
        signup=new JButton("Sign up");
        this.add(signin);
        this.add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Sign in"))
       {

           this.dispose();
           SignIn p2 = new SignIn();
       }
       else if(e.getActionCommand().equals("Sign up")){
           this.dispose();
           SignUp p2 = new SignUp();
       }

    }

    }

