package gui;

import api.Room;
import api.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FindRoomGuest extends JFrame implements ActionListener{
    private String type;
    private Guest guest;
    private ArrayList<Room> rooms;
    private JTextField name,city;
    private JButton find;
    private JRadioButton hotel,apar,mais;
    JCheckBox vpool,vbeach,vsea,vport,vmountain,vroad,hairdryer,wm,dryer,tv,fireplace,airconditioning,centralheating,wifi,ethernet,kitchen,fridge,microwave,cookingt,dishforksknives,dishwasher,coffemaker,balcony,yard,parkp,parkr;

    public FindRoomGuest(String type, Guest guest){
          this.setVisible(true);
          this.setTitle("Find a room");
          this.setSize( 700, 400);
          this.setResizable(true);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          this.setLocationRelativeTo(null);
          this.setLayout(new FlowLayout());

          this.type=type;
          this.guest=guest;
          this.rooms=new ArrayList<>();

          JPanel panel5=new JPanel();
          this.add(panel5);
          JLabel mnm=new JLabel("Συμπληρώστε οποιαδήποτε απο τα παρακάτω θέλετε: ");
          panel5.add(mnm);
          JPanel panel1=new JPanel();
          this.add(panel1);
          JLabel mnm1=new JLabel("Όνομα: ");
          name=new JTextField(30);
          panel1.add(mnm1);
          panel1.add(name);
          JPanel panel2=new JPanel();
          this.add(panel2);
          hotel=new JRadioButton("Ξενοδοχείο");
          apar=new JRadioButton("Διαμέρισμα");
          mais=new JRadioButton("Μεζονέτα");
          panel2.add(hotel);
          panel2.add(apar);
          panel2.add(mais);
          JPanel panel3=new JPanel();
          this.add(panel3);
          JLabel mnm3=new JLabel("Τοποθεσία(π.χ. Θεσσαλονίκη, Αθήνα): ");
          city =new JTextField(30);
          panel3.add(mnm3);
          panel3.add(city);
          continueFrame();
      }

      public void continueFrame(){
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
          JPanel panel4=new JPanel();
          this.add(panel4);
          panel4.add(find=new JButton("SHOW ROOMS"));
          find.addActionListener(this);
          JPanel panel5=new JPanel();
          this.add(panel5);
          JButton back=new JButton("Back to Menu");
          back.addActionListener(this);
          panel5.add(back);
      }

      public void actionPerformed(ActionEvent a) {
         if(a.getActionCommand().equals("Back to Menu")){
             this.dispose();
             GuestMenu g=new GuestMenu(guest);
         }
         else{
             ArrayList<Room> R = new ArrayList<>();
             try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Rooms.bin"))) {
                 R = (ArrayList<Room>) in.readObject();
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (ClassNotFoundException e) {
                 throw new RuntimeException(e);
             }
             if (!name.getText().equals("")) {
                 for (Iterator<Room> it = R.iterator(); it.hasNext(); ) {
                     Room room=it.next();
                     if (!room.getName().equals(name.getText())) {
                         it.remove();
                     }
                 }
             }
             if (!city.getText().equals("")) {
                 for (Iterator<Room> it = R.iterator(); it.hasNext(); ) {
                     Room room = it.next();
                     if (!room.getCity().equals(city.getText())) {
                         it.remove();
                     }
                 }
             }
             boolean flag2 = false;
             for (Iterator<Room> it = R.iterator(); it.hasNext(); ) {
                 Room room = it.next();
                 if (hotel.isSelected()) {
                     if (!room.getType().equals("Ξενοδοχείο")) {
                         it.remove();
                         flag2 = true;
                     }
                 }
                 if (mais.isSelected() && !flag2) {
                     if (!room.getType().equals("Μεζονέτα")) {
                         it.remove();
                         flag2 = true;
                     }
                 }
                 if (apar.isSelected() && !flag2) {
                     if (!room.getType().equals("Διαμέρισμα")) {
                         it.remove();
                     }
                 }
             }
             for (Iterator<Room> it = R.iterator(); it.hasNext(); ) {
                 Room room = it.next();
                 ArrayList<String> par=room.getParoxes();
                 if(vpool.isSelected()){
                     if(!par.contains("Θέα σε πισίνα")){
                         it.remove();
                         continue;
                     }
                 }
                 if(vbeach.isSelected()){
                     if(!par.contains("Θέα σε παραλία")){
                         it.remove();
                         continue;
                     }
                 }
                 if(vsea.isSelected()){
                     if(!par.contains("Θέα στη θάλασσα")){
                         it.remove();
                         continue;
                     }
                 }
                 if(vport.isSelected()){
                     if (!par.contains("Θέα στο λιμάνι")){
                         it.remove();
                         continue;
                     }
                 }
                 if(vmountain.isSelected()){
                     if (!par.contains("Θέα στο βουνό")){
                         it.remove();
                         continue;
                     }
                 }
                 if(vroad.isSelected()){
                     if (!par.contains("Θέα στον δρόμο")){
                         it.remove();
                         continue;
                     }
                 }
                 if(hairdryer.isSelected()){
                     if (!par.contains("Πιστολάκι μαλλιών")){
                         it.remove();
                         continue;
                     }
                 }
                 if(wm.isSelected()){
                     if (!par.contains("Πλυντήριο ρούχων")){
                         it.remove();
                         continue;
                     }
                 }
                 if(dryer.isSelected()){
                     if (!par.contains("Στεγνωτήριο")){
                         it.remove();
                         continue;
                     }
                 }
                 if(tv.isSelected()){
                     if (!par.contains("Τηλεόραση")){
                         it.remove();
                         continue;
                     }
                 }
                 if(fireplace.isSelected()){
                     if (!par.contains("Εσωτερικό τζάκι")){
                         it.remove();
                         continue;
                     }
                 }
                 if(airconditioning.isSelected()){
                     if (!par.contains("κλιματισμός")){
                         it.remove();
                         continue;
                     }
                 }
                 if(centralheating.isSelected()){
                     if (!par.contains("κεντρική θέρμανση")){
                         it.remove();
                         continue;
                     }
                 }
                 if(wifi.isSelected()){
                     if (!par.contains("wifi")){
                         it.remove();
                         continue;
                     }
                 }
                 if(ethernet.isSelected()){
                     if (!par.contains("ethernet")){
                         it.remove();
                         continue;
                     }
                 }
                 if(kitchen.isSelected()){
                     if (!par.contains("Κουζίνα")){
                         it.remove();
                         continue;
                     }
                 }
                 if(fridge.isSelected()){
                     if (!par.contains("Ψυγείο")){
                         it.remove();
                         continue;
                     }
                 }
                 if(microwave.isSelected()){
                     if (!par.contains("Φούρνος μικροκυμάτων")){
                         it.remove();
                         continue;
                     }
                 }
                 if(cookingt.isSelected()){
                     if (!par.contains("Μαγειρικά είδη")){
                         it.remove();
                         continue;
                     }
                 }
                 if(dishforksknives.isSelected()){
                     if (!par.contains("Πιάτα και μαχαιροπίρουνα")){
                         it.remove();
                         continue;
                     }
                 }
                 if(dishwasher.isSelected()){
                     if (!par.contains("Πλυντήριο πιάτων")){
                         it.remove();
                         continue;
                     }
                 }
                 if(coffemaker.isSelected()){
                     if (!par.contains("Καφετιέρα")){
                         it.remove();
                         continue;
                     }
                 }
                 if(balcony.isSelected()){
                     if (!par.contains("Μπαλκόνι")){
                         it.remove();
                         continue;
                     }
                 }
                 if(yard.isSelected()){
                     if (!par.contains("αυλή")){
                         it.remove();
                         continue;
                     }
                 }
                 if(parkp.isSelected()){
                     if (!par.contains("Δωρεάν χώρος στάθμευσης στην ιδιοκτησία")){
                         it.remove();
                         continue;
                     }
                 }
                 if(parkr.isSelected()){
                     if (!par.contains("Δωρεάν πάρκινγκ στο δρόμο")){
                         it.remove();
                     }
                 }

             }
             if (R.size() == 0) {
                 NoRoom g=new NoRoom();
             }
             else {
                 this.dispose();
                 ShowSearchRooms g = new ShowSearchRooms(R, type, guest);
             }
         }

      }
}



