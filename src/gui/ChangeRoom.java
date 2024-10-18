package gui;

import api.Provider;
import api.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ChangeRoom extends JFrame implements ActionListener {
    private Room room;
    private String username;


    JLabel name,type,dief,city,tnumber,description,paroxes;
    JButton add;
    JTextField nameb,diefb,cityb,tnumberb,descriptionb;
    JRadioButton hotel,apartment,maisonette;
    JCheckBox vpool,vbeach,vsea,vport,vmountain,vroad,hairdryer,wm,dryer,tv,fireplace,airconditioning,centralheating,wifi,ethernet,kitchen,fridge,microwave,cookingt,dishforksknives,dishwasher,coffemaker,balcony,yard,parkp,parkr;
    public ChangeRoom(Room room,String username){
        this.setVisible(true);
        this.setTitle("Change Room");
        this.setSize( 400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        this.room=room;
        this.username=username;

        name=new JLabel("Name");
        this.add(name);
        nameb=new JTextField(12);
        this.add(nameb);

        type=new JLabel("Type");
        this.add(type);
        hotel=new JRadioButton("Ξενοδοχείο");
        this.add(hotel);
        apartment=new JRadioButton("Διαμέρισμα");
        this.add(apartment);
        maisonette=new JRadioButton("Μεζονέτα");
        this.add(maisonette);
        ButtonGroup group1=new ButtonGroup();
        group1.add(hotel);
        group1.add(apartment);
        group1.add(maisonette);
        hotel.setSelected(true);

        dief=new JLabel("Address");
        this.add(dief);
        diefb=new JTextField(12);
        this.add(diefb);

        city=new JLabel("City");
        this.add(city);
        cityb=new JTextField(12);
        this.add(cityb);

        tnumber=new JLabel("Postcode");
        this.add(tnumber);
        tnumberb=new JTextField(12);
        this.add(tnumberb);

        description=new JLabel("Description");
        this.add(description);
        descriptionb=new JTextField(12);
        this.add(descriptionb);

        paroxes=new JLabel("Benefits:");
        this.add(paroxes);
        vpool=new JCheckBox("Θέα σε πισίνα");
        this.add(vpool);
        vbeach=new JCheckBox("Θέα σε παραλία");
        this.add(vbeach);
        vsea=new JCheckBox("Θέα στη θάλασσα");
        this.add(vsea);
        vport=new JCheckBox("Θέα στο λιμάνι");
        this.add(vport);
        vmountain=new JCheckBox("Θέα στο βουνό");
        this.add(vmountain);
        vroad=new JCheckBox("Θέα στον δρόμο");
        this.add(vroad);
        hairdryer=new JCheckBox("Πιστολάκι μαλλιών");
        this.add(hairdryer);
        wm=new JCheckBox("Πλυντήριο ρούχων");
        this.add(wm);
        dryer=new JCheckBox("Στεγνωτήριο");
        this.add(dryer);
        tv=new JCheckBox("Τηλεόραση");
        this.add(tv);
        fireplace=new JCheckBox("Εσωτερικό τζάκι");
        this.add(fireplace);
        airconditioning=new JCheckBox("κλιματισμός");
        this.add(airconditioning);
        centralheating=new JCheckBox("κεντρική θέρμανση");
        this.add(centralheating);
        wifi=new JCheckBox("wifi");
        this.add(wifi);
        ethernet=new JCheckBox("ethernet");
        this.add(ethernet);
        kitchen=new JCheckBox("Κουζίνα");
        this.add(kitchen);
        fridge=new JCheckBox("Ψυγείο");
        this.add(fridge);
        microwave=new JCheckBox("Φούρνος μικροκυμάτων");
        this.add(microwave);
        cookingt=new JCheckBox("Μαγειρικά είδη");
        this.add(cookingt);
        dishforksknives=new JCheckBox("Πιάτα και μαχαιροπίρουνα");
        dishwasher=new JCheckBox("Πλυντήριο πιάτων");
        this.add(dishwasher);
        coffemaker=new JCheckBox("Καφετιέρα");
        this.add(coffemaker);
        balcony=new JCheckBox("Μπαλκόνι");
        this.add(balcony);
        yard=new JCheckBox("αυλή");
        this.add(yard);
        parkp=new JCheckBox("Δωρεάν χώρος στάθμευσης στην ιδιοκτησία");
        this.add(parkp);
        parkr=new JCheckBox("Δωρεάν πάρκινγκ στο δρόμο");
        this.add(parkr);

        add=new JButton("CHANGE");
        this.add(add);
        add.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if((nameb.getText().isEmpty())||(diefb.getText().isEmpty())||(cityb.getText().isEmpty())||(tnumberb.getText().isEmpty())||(descriptionb.getText().isEmpty())){
            WrongInput p=new WrongInput();
        }
        else {

            String tp;
            if (hotel.isSelected())
                tp = "HOTEL";
            else if (apartment.isSelected())
                tp = "APARTMENT";
            else
                tp = "MAISONETTE";
            ArrayList<String> par = new ArrayList<>();
            if(vpool.isSelected())
                par.add("Θέα σε πισίνα");
            if(vbeach.isSelected())
                par.add("Θέα σε παραλία");
            if(vsea.isSelected())
                par.add("Θέα στη θάλασσα");
            if(vport.isSelected())
                par.add("Θέα στο λιμάνι");
            if(vmountain.isSelected())
                par.add("Θέα στο βουνό");
            if(vroad.isSelected())
                par.add("Θέα στον δρόμο");
            if(hairdryer.isSelected())
                par.add("Πιστολάκι μαλλιών");
            if(wm.isSelected())
                par.add("Πλυντήριο ρούχων");
            if(dryer.isSelected())
                par.add("Στεγνωτήριο");
            if(tv.isSelected())
                par.add("Τηλεόραση");
            if(fireplace.isSelected())
                par.add("Εσωτερικό τζάκι");
            if(airconditioning.isSelected())
                par.add("κλιματισμός");
            if(centralheating.isSelected())
                par.add("κεντρική θέρμανση");
            if(wifi.isSelected())
                par.add("wifi");
            if(ethernet.isSelected())
                par.add("ethernet");
            if(kitchen.isSelected())
                par.add("Κουζίνα");
            if(fridge.isSelected())
                par.add("Ψυγείο");
            if(microwave.isSelected())
                par.add("Φούρνος μικροκυμάτων");
            if(cookingt.isSelected())
                par.add("Μαγειρικά είδη");
            if(dishforksknives.isSelected())
                par.add("Πιάτα και μαχαιροπίρουνα");
            if(dishwasher.isSelected())
                par.add("Πλυντήριο πιάτων");
            if(coffemaker.isSelected())
                par.add("Καφετιέρα");
            if(balcony.isSelected())
                par.add("Μπαλκόνι");
            if(yard.isSelected())
                par.add("αυλή");
            if(parkp.isSelected())
                par.add("Δωρεάν χώρος στάθμευσης στην ιδιοκτησία");
            if(parkr.isSelected())
                par.add("Δωρεάν πάρκινγκ στο δρόμο");

            Room r = new Room(nameb.getText(), tp, diefb.getText(), cityb.getText(), tnumberb.getText(), descriptionb.getText(),room.getProvider(), par);
            ArrayList<Room> R = new ArrayList<>();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Rooms.bin"))) {
                R = (ArrayList<Room>) in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }



            ArrayList<Provider> P = new ArrayList<>();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Providers.bin"))) {
                P = (ArrayList<Provider>) in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            int nu=0;
            for(Room l:R){
                if(l.getName().equals(room.getName())){
                    break;
                }
                nu++;
            }
            R.remove(nu);
            R.add(r);

            int num = 0;
            for (Provider an : P) {
                if (room.getProvider().getUsername().equals(an.getUsername())) {
                    break;
                }
                num++;
            }
            P.remove(num);
            room.getProvider().deleteRoom(room);
            room.getProvider().addRoom(nameb.getText(), tp, diefb.getText(), cityb.getText(), tnumberb.getText(), descriptionb.getText(),par);
            P.add(room.getProvider());


            Path a1 = Paths.get("Rooms.bin");
            try {
                Files.delete(a1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
                out.writeObject(R);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Path a2 = Paths.get("Providers.bin");
            try {
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
            ProviderMenu w = new ProviderMenu(room.getProvider());
            Success s = new Success();
        }
    }
}
