package gui;

import api.Guest;
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
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ShowRoom extends JFrame implements ActionListener {
    private static final Logger LOGGER = Logger.getLogger(ShowRoom.class.getName());
    private static final String GUESTS_FILE = "Guests.bin";
    private static final String ROOMS_FILE = "Rooms.bin";
    private static final String PROVIDERS_FILE = "Providers.bin";
    
    private final String user;
    private final String username;
    private final Room room;

    public ShowRoom(String user, Room room, String username) {
        this.user = user;
        this.room = room;
        this.username = username;
        
        initializeFrame();
        setupComponents();
    }

    private void initializeFrame() {
        this.setVisible(true);
        this.setTitle("Show a room");
        this.setSize(400, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout grid = new GridLayout(9, 0);
        this.setLayout(grid);
    }

    private void setupComponents() {
        JLabel name = new JLabel("Hotel Name: " + room.getName());
        JLabel type = new JLabel("Type: " + room.getType());
        JLabel dief = new JLabel("Address: " + room.getDief());
        JLabel city = new JLabel("City: " + room.getCity());
        JLabel tnumber = new JLabel("Tnumber: " + room.getTnumber());
        JLabel description = new JLabel(room.getDescription());

        this.add(name);
        this.add(type);
        this.add(dief);
        this.add(city);
        this.add(tnumber);
        this.add(description);

        JPanel panel1 = new JPanel();
        this.add(panel1);
        JLabel k = new JLabel("Παροχές: ");
        panel1.add(k);
        for (String a : room.getParoxes()) {
            JLabel i = new JLabel(a);
            panel1.add(i);
        }

        JPanel panel2 = new JPanel();
        this.add(panel2);
        JButton show = new JButton("Show reviews");
        show.addActionListener(this);
        panel2.add(show);

        JPanel panel3 = new JPanel();
        this.add(panel3);
        
        if ("Provider".equals(user)) {
            JButton change = new JButton("Change Room");
            JButton delete = new JButton("Delete Room");
            change.addActionListener(this);
            delete.addActionListener(this);
            panel3.add(change);
            panel3.add(delete);
        }
        if ("Guest".equals(user)) {
            JButton add = new JButton("Add review");
            add.addActionListener(this);
            panel3.add(add);
            JButton back = new JButton("Back to Menu");
            back.addActionListener(this);
            panel3.add(back);
        }
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String command = a.getActionCommand();
        
        if ("Show reviews".equals(command)) {
            new ShowReviews(room);
        } else if ("Add review".equals(command)) {
            this.dispose();
            new AddReview(room, username);
        } else if ("Change Room".equals(command)) {
            this.dispose();
            new ChangeRoom(room, username);
        } else if ("Back to Menu".equals(command)) {
            handleBackToMenu();
        } else if ("Delete Room".equals(command)) {
            handleDeleteRoom();
        }
    }

    private void handleBackToMenu() {
        List<Guest> guests = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(GUESTS_FILE))) {
            guests = (List<Guest>) in.readObject();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading guests file", e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Class not found when reading guests", e);
        }

        for (Guest b : guests) {
            if (b.getUsername().equals(username)) {
                this.dispose();
                new GuestMenu(b);
                break;
            }
        }
    }

    private void handleDeleteRoom() {
        List<Room> rooms = loadRooms();
        removeRoomFromList(rooms);
        saveRooms(rooms);
        
        List<Provider> providers = loadProviders();
        updateProviderRooms(providers);
        saveProviders(providers);

        this.dispose();
        new ProviderMenu(room.getProvider());
    }

    private List<Room> loadRooms() {
        List<Room> rooms = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ROOMS_FILE))) {
            rooms = (List<Room>) in.readObject();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading rooms file", e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Class not found when reading rooms", e);
        }
        return rooms;
    }

    private void removeRoomFromList(List<Room> rooms) {
        int pl = 0;
        for (Room r : rooms) {
            if (r.getName().equals(room.getName())) {
                break;
            }
            pl++;
        }
        rooms.remove(pl);
    }

    private void saveRooms(List<Room> rooms) {
        Path roomsPath = Paths.get(ROOMS_FILE);
        try {
            Files.delete(roomsPath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error deleting rooms file", e);
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ROOMS_FILE))) {
            out.writeObject(rooms);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing rooms file", e);
        }
    }

    private List<Provider> loadProviders() {
        List<Provider> providers = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PROVIDERS_FILE))) {
            providers = (List<Provider>) in.readObject();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading providers file", e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Class not found when reading providers", e);
        }
        return providers;
    }

    private void updateProviderRooms(List<Provider> providers) {
        int pq = 0;
        for (Provider pro : providers) {
            if (pro.getUsername().equals(room.getProvider().getUsername())) {
                break;
            }
            pq++;
        }
        providers.remove(pq);
        room.getProvider().deleteRoom(room);
        providers.add(room.getProvider());
    }

    private void saveProviders(List<Provider> providers) {
        Path providersPath = Paths.get(PROVIDERS_FILE);
        try {
            Files.delete(providersPath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error deleting providers file", e);
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PROVIDERS_FILE))) {
            out.writeObject(providers);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing providers file", e);
        }
    }
}
