package api;
import java.io.Serializable;
import java.util.*;

/**
 * κλάση για τα στοιχεία ενός επισκέπτη
 * @author Αθανάσιος Γκουτής
 */
public class Guest extends User implements Serializable {
    private HashMap<String,String> reviews;
    private HashMap<String,Integer> stars;
    private HashMap<String,String> dates;

    /**
     * κατασκευαστής της κλάσης
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param type
     */
    public Guest(String firstname,String lastname,String username,String password,String type){
        super(firstname,lastname,username,password,type);
        this.reviews=new HashMap<>();
        this.dates=new HashMap<>();
        this.stars=new HashMap<>();
    }


    /**
     * μέθοδος για την προσθήκη αξιολόγησης ενός επισκέπτη για ενα ξενοδοχείο
     * @param roomname
     * @param review
     * @param star
     * @param date
     */
    public void addReview(String roomname,String review,int star,String date){
        reviews.put(roomname,review);
        stars.put(roomname,star);
        dates.put(roomname,date);
    }

    /**
     * μέθοδος για τη διαγραφή αξιολόγησης ενός επισκέπτη για ενα ξενοδοχείο
     * @param roomname
     */
    public void removeReview(String roomname){
        dates.remove(roomname);
        reviews.remove(roomname);
        stars.remove(roomname);
    }

    /**
     * getter για τις ημερομηνίες των αξιολογήσεων του επισκέπτη
     * @return dates
     */
    public HashMap<String,String> getDates(){
        return dates;
    }

    /**
     * getter για τa κείμενα των αξιολογήσεων του επισκέπτη
     * @return reviews
     */
    public HashMap<String,String> getReviews(){
        return reviews;
    }

    }
