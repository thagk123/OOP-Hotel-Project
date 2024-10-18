package gui;
import api.Room;
import api.Provider;
import api.Guest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *κλάση που αναπαριστά τη main
 * @author Αθανάσιος Γκουτής
 */
public class Main {

    /**
     * μέθοδος για την αρχικοποίηση του προγράμματος μέσω αρχείων και την έναρξη της εφαρμογής
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Provider> providers=new ArrayList<>();
        ArrayList<Guest> guests=new ArrayList<>();
        ArrayList<Room> allrooms=new ArrayList<>();


        Path p1= Paths.get("provider1.bin");
        Path p2= Paths.get("provider2.bin");
        Path p3= Paths.get("guest1.bin");
        Path p4= Paths.get("guest2.bin");
        Path p5= Paths.get("Providers.bin");
        Path p6= Paths.get("Guests.bin");
        Path p7= Paths.get("Rooms.bin");

      if (Files.notExists(p1)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("provider1.bin"))) {
                Provider a1 = new Provider("Δημήτρης", "Καγγελίδης", "dkagg", "123", "Provider");
                oos.writeObject(a1);
                ArrayList<String> provider1_hotel1_paroxes = new ArrayList<>();
                provider1_hotel1_paroxes.add("Θεα στην θάλασσα");
                provider1_hotel1_paroxes.add("wifi");
                provider1_hotel1_paroxes.add("Μπαλκόνι");
                oos.writeObject(a1.addRoom("Makedonia Palace", "Ξενοδοχείο", "Τσιμισκή 1", "Θεσσαλονίκη", "55132", "Παραλιακό",provider1_hotel1_paroxes));
                ArrayList<String> provider1_hotel2_paroxes = new ArrayList<>();
                provider1_hotel2_paroxes.add("Θεα σε πισίνα");
                provider1_hotel2_paroxes.add("Πιστολάκι μαλλιών");
                provider1_hotel2_paroxes.add("Ψυγείο");
                oos.writeObject(a1.addRoom("Esperos Palace Luxury & Spa Hotel", "Ξενοδοχείο", "Νίκης 1", "Αθήνα", "60132", "Στο κέντρο της πόλης",provider1_hotel2_paroxes));
                ArrayList<String> provider1_hotel3_paroxes = new ArrayList<>();
                provider1_hotel3_paroxes.add("Θεα σε πισίνα");
                provider1_hotel3_paroxes.add("Τηλεόραση");
                provider1_hotel3_paroxes.add("Ψυγείο");
                oos.writeObject(a1.addRoom("Maison Hotel", "Ξενοδοχείο", "Παπαδόπουλου 16", "Λάρισα", "59112", "Στο πιο όμορφο μέρος της Λάρισας",provider1_hotel3_paroxes));
                ArrayList<String> provider1_hotel4_paroxes = new ArrayList<>();
                provider1_hotel4_paroxes.add("Θεα σε θάλασσα");
                provider1_hotel4_paroxes.add("Δωρεάν χώρος στάθμευσης στην ιδιοκτησία");
                provider1_hotel4_paroxes.add("Θέα στον δρόμο");
                oos.writeObject(a1.addRoom("Electra Palace Thessaloniki", "Ξενοδοχείο", "Αριστοτέλους 3", "Θεσσαλονίκη", "50222", "Με θεα το λιμάνι και την πλατεία Αριστοτέλους",provider1_hotel4_paroxes));
                ArrayList<String> provider1_hotel5_paroxes = new ArrayList<>();
                provider1_hotel5_paroxes.add("Θεα σε θάλασσα");
                provider1_hotel5_paroxes.add("ethernet");
                provider1_hotel5_paroxes.add("Δωρεάν πάρκινγκ στο δρόμο");
                oos.writeObject(a1.addRoom("Lucy Hotel", "Ξενοδοχείο", "Παπαγεωργίου 122", "Καβάλα", "12554", "Με θεα την θάλασσα και την πανέμορφη Θάσο",provider1_hotel5_paroxes));

            } catch (IOException e) {
                e.printStackTrace();
            }



            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("provider1.bin"))) {
                providers.add((Provider) oos.readObject());
                for (int i = 0; i < 5; i++) {
                    allrooms.add((Room) oos.readObject());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        if(Files.notExists(p2)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("provider2.bin"))) {
                Provider a2 = new Provider("Γιούλη", "Γκουτή", "gioulg", "456", "Provider");
                oos.writeObject(a2);
                ArrayList<String> provider2_hotel1_paroxes = new ArrayList<>();
                provider2_hotel1_paroxes.add("Θέα στο βουνό");
                provider2_hotel1_paroxes.add("Δωρεάν χώρος στάθμευσης στην ιδιοκτησία");
                provider2_hotel1_paroxes.add("αυλή");
                oos.writeObject(a2.addRoom("HOTEL FARAGI", "Ξενοδοχείο", "Γεωργίου Καραϊσκάκη 33", "Τρίπολη", "40443", "Ξενοδοχείο κοντά στο φαράγγι της Τρίπολης",provider2_hotel1_paroxes));
                ArrayList<String> provider2_hotel2_paroxes = new ArrayList<>();
                provider2_hotel2_paroxes.add("Θεα στο δρόμο");
                provider2_hotel2_paroxes.add("Πιστολάκι μαλλιών");
                provider2_hotel2_paroxes.add("Ψυγείο");
                oos.writeObject(a2.addRoom("Ξενοδοχείο Φαίδων", "Ξενοδοχείο", "Βούλγαρη 22", "Θεσσαλονίκη", "54122", "Ξενοδοχείο στα ανατολικά της Θεσσαλονίκης",provider2_hotel2_paroxes));
                ArrayList<String> provider2_hotel3_paroxes = new ArrayList<>();
                provider2_hotel3_paroxes.add("Θεα στο βουνό");
                provider2_hotel3_paroxes.add("Εσωτερικό τζάκι");
                provider2_hotel3_paroxes.add("wifi");
                oos.writeObject(a2.addRoom("The Lynx Mountain Resort", "Ξενοδοχείο", "Καραγεωργίου 123", "Φλώρινα", "51222", "Με θεα τα πανέμορφα βουνά της Φλώρινας",provider2_hotel3_paroxes));
                ArrayList<String> provider2_hotel4_paroxes = new ArrayList<>();
                provider2_hotel4_paroxes.add("Θεα σε θάλασσα");
                provider2_hotel4_paroxes.add("Δωρεάν χώρος στάθμευσης στην ιδιοκτησία");
                provider2_hotel4_paroxes.add("Θέα στον δρόμο");
                oos.writeObject(a2.addRoom("Phidias Piraeus Hotel", "Ξενοδοχείο", "Φάληρου 33", "Πειραιάς", "23332", "Με θεα το λιμάνι του Πειραιά",provider2_hotel4_paroxes));
                ArrayList<String> provider2_hotel5_paroxes = new ArrayList<>();
                provider2_hotel5_paroxes.add("Θεα στο δρόμο");
                provider2_hotel5_paroxes.add("κεντρική θέρμανση");
                provider2_hotel5_paroxes.add("ethernet");
                oos.writeObject(a2.addRoom("Athens Golden City Hotel", "Ξενοδοχείο", "Ομονοίας 55", "Αθήνα", "24832", "Στο κέντρο της Ομόνοιας",provider2_hotel5_paroxes));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("provider2.bin"))) {
                providers.add((Provider) oos.readObject());
                for (int i = 0; i < 5; i++) {
                    allrooms.add((Room) oos.readObject());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
       }

        if(Files.notExists(p3)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("guest1.bin"))) {
                Guest b1 = new Guest("Θάνος", "Γκουτής", "tgout", "abc", "Guest");
                oos.writeObject(b1);
                List<String> review1 = Arrays.asList("Ένα από τα καλύτερα ξενοδοχεία της βόρειας Ελλάδας", "5","21/5/2018");
                List<String> review2 = Arrays.asList("Ομολογώ πως ήταν όλα υπέροχα", "3","4/1/2022");
                List<String> review3 = Arrays.asList("Πολύ καλό πρωινό με φρέσκα φρούτα", "4","5/8/2015");
                List<String> review4 = Arrays.asList("Ένα από τα καλύτερα ξενοδοχεία της βόρειας Ελλάδας", "3","26/11/2021");
                List<String> review5 = Arrays.asList("Ομολογώ πως ήταν όλα υπέροχα", "3","7/7/2021");
                List<String> review6 = Arrays.asList("Πολύ καλό πρωινό με φρέσκα φρούτα", "4","5/4/2012");
                List<String> review7 = Arrays.asList("Ένα από τα καλύτερα ξενοδοχεία της βόρειας Ελλάδας","5","6/2/2019");
                List<String> review8 = Arrays.asList("Ομολογώ πως ήταν όλα υπέροχα", "5","13/8/2022");
                List<String> review9 = Arrays.asList("Πολύ καλό πρωινό με φρέσκα φρούτα", "5","12/5/2017");
                List<String> review10 = Arrays.asList("Το στυλ του ξενοδοχείου είναι πολύ μουντό", "2","6/8/2020");
                oos.writeObject(review1);
                oos.writeObject(review2);
                oos.writeObject(review3);
                oos.writeObject(review4);
                oos.writeObject(review5);
                oos.writeObject(review6);
                oos.writeObject(review7);
                oos.writeObject(review8);
                oos.writeObject(review9);
                oos.writeObject(review10);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("guest1.bin"))) {
                Guest b1 = (Guest) oos.readObject();
                guests.add(b1);
                List<String> review1;
                review1 = (List<String>) oos.readObject();
                allrooms.get(0).addreview(b1.getUsername(), review1.get(0), Integer.parseInt(review1.get(1)),review1.get(2));
                b1.addReview("Makedonia Palace", review1.get(0), Integer.parseInt(review1.get(1)),review1.get(2));
                List<String> review2;
                review2 = (List<String>) oos.readObject();
                allrooms.get(1).addreview(b1.getUsername(), review2.get(0), Integer.parseInt(review2.get(1)),review2.get(2));
                b1.addReview("Esperos Palace Luxury & Spa Hotel", review2.get(0), Integer.parseInt(review2.get(1)),review2.get(2));
                List<String> review3;
                review3 = (List<String>) oos.readObject();
                allrooms.get(2).addreview(b1.getUsername(), review3.get(0), Integer.parseInt(review3.get(1)),review3.get(2));
                b1.addReview("Maison Hotel", review3.get(0), Integer.parseInt(review3.get(1)),review3.get(2));
                List<String> review4;
                review4 = (List<String>) oos.readObject();
                allrooms.get(3).addreview(b1.getUsername(), review4.get(0), Integer.parseInt(review4.get(1)),review4.get(2));
                b1.addReview("Electra Palace Thessaloniki", review4.get(0), Integer.parseInt(review4.get(1)),review4.get(2));
                List<String> review5;
                review5 = (List<String>) oos.readObject();
                allrooms.get(4).addreview(b1.getUsername(), review5.get(0), Integer.parseInt(review5.get(1)),review5.get(2));
                b1.addReview("Lucy Hotel", review5.get(0), Integer.parseInt(review5.get(1)),review5.get(2));
                List<String> review6;
                review6 = (List<String>) oos.readObject();
                allrooms.get(5).addreview(b1.getUsername(), review6.get(0), Integer.parseInt(review6.get(1)),review6.get(2));
                b1.addReview("HOTEL FARAGI", review6.get(0), Integer.parseInt(review6.get(1)),review6.get(2));
                List<String> review7;
                review7 = (List<String>) oos.readObject();
                allrooms.get(6).addreview(b1.getUsername(), review7.get(0), Integer.parseInt(review7.get(1)),review7.get(2));
                b1.addReview("Ξενοδοχείο Φαίδων", review7.get(0), Integer.parseInt(review7.get(1)),review7.get(2));
                List<String> review8;
                review8 = (List<String>) oos.readObject();
                allrooms.get(7).addreview(b1.getUsername(), review8.get(0), Integer.parseInt(review8.get(1)),review8.get(2));
                b1.addReview("The Lynx Mountain Resort", review8.get(0), Integer.parseInt(review8.get(1)),review8.get(2));
                List<String> review9;
                review9 = (List<String>) oos.readObject();
                allrooms.get(8).addreview(b1.getUsername(), review9.get(0), Integer.parseInt(review9.get(1)),review9.get(2));
                b1.addReview("Phidias Piraeus Hotel", review9.get(0), Integer.parseInt(review9.get(1)),review9.get(2));
                List<String> review10;
                review10 = (List<String>) oos.readObject();
                allrooms.get(9).addreview(b1.getUsername(), review10.get(0), Integer.parseInt(review10.get(1)),review10.get(2));
                b1.addReview("Athens Golden City Hotel", review10.get(0), Integer.parseInt(review10.get(1)),review10.get(2));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(Files.notExists(p4)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("guest2.bin"))) {
                Guest b2 = new Guest("Μάκης", "Δημάκης", "mdim", "abc123", "Guest");
                oos.writeObject(b2);
                List<String> review1 = Arrays.asList("Η καλύτερη θεα της Θεσσαλονίκης", "4","5/9/2020");
                List<String> review2 = Arrays.asList("Αρκετά καλή επιλογή αν θες να είσαι κοντά στο κέντρο", "3","7/7/2018");
                List<String> review3 = Arrays.asList("Εξαιρετικό προσωπικό και καθαρό ξενοδοχείο", "4","25/6/2022");
                List<String> review4 = Arrays.asList("Η καλύτερη θεα της Θεσσαλονίκης","2","2/5/2020");
                List<String> review5 = Arrays.asList("Αρκετά καλή επιλογή αν θες να είσαι κοντά στο κέντρο", "3","18/12/2022");
                List<String> review6 = Arrays.asList("Εξαιρετικό προσωπικό και καθαρό ξενοδοχείο", "4","6/9/2021");
                List<String> review7 = Arrays.asList("Η καλύτερη θεα της Θεσσαλονίκης", "2","4/2/2018");
                List<String> review8 = Arrays.asList("Αρκετά καλή επιλογή αν θες να είσαι κοντά στο κέντρο", "5","12/3/2019");
                List<String> review9 = Arrays.asList("Εξαιρετικό προσωπικό και καθαρό ξενοδοχείο", "5","3/3/2022");
                List<String> review10 = Arrays.asList("Εξαιρετικό roof garden", "2","29/8/2018");
                oos.writeObject(review1);
                oos.writeObject(review2);
                oos.writeObject(review3);
                oos.writeObject(review4);
                oos.writeObject(review5);
                oos.writeObject(review6);
                oos.writeObject(review7);
                oos.writeObject(review8);
                oos.writeObject(review9);
                oos.writeObject(review10);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("guest2.bin"))) {
                Guest b2 = (Guest) oos.readObject();
                guests.add(b2);
                List<String> review1;
                review1 = (List<String>) oos.readObject();
                allrooms.get(0).addreview(b2.getUsername(), review1.get(0), Integer.parseInt(review1.get(1)),review1.get(2));
                b2.addReview("Makedonia Palace", review1.get(0), Integer.parseInt(review1.get(1)),review1.get(2));
                List<String> review2;
                review2 = (List<String>) oos.readObject();
                allrooms.get(1).addreview(b2.getUsername(), review2.get(0), Integer.parseInt(review2.get(1)),review2.get(2));
                b2.addReview("Esperos Palace Luxury & Spa Hotel", review2.get(0), Integer.parseInt(review2.get(1)),review2.get(2));
                List<String> review3;
                review3 = (List<String>) oos.readObject();
                allrooms.get(2).addreview(b2.getUsername(), review3.get(0), Integer.parseInt(review3.get(1)),review3.get(2));
                b2.addReview("Maison Hotel", review3.get(0), Integer.parseInt(review3.get(1)),review3.get(2));
                List<String> review4;
                review4 = (List<String>) oos.readObject();
                allrooms.get(3).addreview(b2.getUsername(), review4.get(0), Integer.parseInt(review4.get(1)),review4.get(2));
                b2.addReview("Electra Palace Thessaloniki", review4.get(0), Integer.parseInt(review4.get(1)),review4.get(2));
                List<String> review5;
                review5 = (List<String>) oos.readObject();
                allrooms.get(4).addreview(b2.getUsername(), review5.get(0), Integer.parseInt(review5.get(1)),review5.get(2));
                b2.addReview("Lucy Hotel", review5.get(0), Integer.parseInt(review5.get(1)),review5.get(2));
                List<String> review6;
                review6 = (List<String>) oos.readObject();
                allrooms.get(5).addreview(b2.getUsername(), review6.get(0), Integer.parseInt(review6.get(1)),review6.get(2));
                b2.addReview("HOTEL FARAGI", review6.get(0), Integer.parseInt(review6.get(1)),review6.get(2));
                List<String> review7;
                review7 = (List<String>) oos.readObject();
                allrooms.get(6).addreview(b2.getUsername(), review7.get(0), Integer.parseInt(review7.get(1)),review7.get(2));
                b2.addReview("Ξενοδοχείο Φαίδων", review7.get(0), Integer.parseInt(review7.get(1)),review7.get(2));
                List<String> review8;
                review8 = (List<String>) oos.readObject();
                allrooms.get(7).addreview(b2.getUsername(), review8.get(0), Integer.parseInt(review8.get(1)),review8.get(2));
                b2.addReview("The Lynx Mountain Resort", review8.get(0), Integer.parseInt(review8.get(1)),review8.get(2));
                List<String> review9;
                review9 = (List<String>) oos.readObject();
                allrooms.get(8).addreview(b2.getUsername(), review9.get(0), Integer.parseInt(review9.get(1)),review9.get(2));
                b2.addReview("Phidias Piraeus Hotel", review9.get(0), Integer.parseInt(review9.get(1)),review9.get(2));
                List<String> review10;
                review10 = (List<String>) oos.readObject();
                allrooms.get(9).addreview(b2.getUsername(), review10.get(0), Integer.parseInt(review10.get(1)),review10.get(2));
                b2.addReview("Athens Golden City Hotel", review10.get(0), Integer.parseInt(review10.get(1)),review10.get(2));

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (Files.notExists(p7)) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
                out.writeObject(allrooms);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(Files.notExists(p6)) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin"))) {
                out.writeObject(guests);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(Files.notExists(p5)) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Providers.bin"))) {
                out.writeObject(providers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Start gui=new Start();
        gui.setVisible(true);

    }

}
