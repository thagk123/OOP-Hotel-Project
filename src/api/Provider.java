package api;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * κλάση για τα στοιχεία του παρόχου
 * @author Δημήτριος Καγγελίδης
 */
public class Provider extends  User implements Serializable {

    private final ArrayList<Room> rooms;

    /**
     * κατασκευαστής της κλάσης
     * @param name
     * @param surname
     * @param username
     * @param password
     * @param type
     */
    public  Provider(String name,String surname,String username,String password,String type){
        super(name,surname,username,password,type);
        rooms=new ArrayList<>();
    }

    /**
     * μέθοδος για την προσθήκη καταλήματος για έναν πάροχο
     * @param name
     * @param type
     * @param dief
     * @param city
     * @param tnumber
     * @param description
     * @param paroxes
     * @return
     */
    public Room addRoom(String name, String type, String dief, String city, String tnumber, String description,ArrayList<String> paroxes){
        Room katalhma=new Room(name,type,dief,city,tnumber,description,this,paroxes);
        rooms.add(katalhma);
        return katalhma;
    }

    /**
     * μέθοδος για τη διαγραφή καταλήματος από τα καταλήματα του παρόχου
     * @param r
     */
    public void deleteRoom(Room r){
        rooms.remove(r);
    }

    /**
     * getter για τα δωμάτια του παρόχου
     * @return
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }


}
