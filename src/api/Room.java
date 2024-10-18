package api;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/** κλάση για τα στοιχεία του καταλήματος καταλύματος
 * @author  Δημήτριος Καγγελίδης Γκουτής Αθανάσιος */

public class Room implements Serializable {
    private String name; //ονομα
    private String type; //τυπος καταλύματος
    private String dief;//διεύθυνση
    private String city; //πόλη
    private String tnumber;//ταχυδρομικός κώδικας
    private String description;//περιγραφή καταλύματος

    private Provider prov; //Ο πάροχος του καταλύματος

    private  ArrayList<String> paroxes;//arraylist με ολες τις παροχές του καταλύματος

    private HashMap<String,String> reviews; //HashMap με τις αξιολογήσεις του κάθε χρήστη για το κατάλυμα

    private HashMap<String,Integer> stars; //HashMap με τα αστέρια που βαθμολογεί ο χρήστης το κατάλυμα

    private HashMap<String,String> dates; //HashMap με την ημερομηνία που έγινε η αξιολόγηση


    /** κατασκευαστής της κλάσης
     *
     * @param name
     * @param type
     * @param dief
     * @param city
     * @param tnumber
     * @param description
     * @param prov
     * @param paroxes
     */
    public Room(String name, String type, String dief, String city, String tnumber, String description,Provider prov,ArrayList<String> paroxes){
        this.name=name;
        this.type=type;
        this.dief=dief;
        this.city=city;
        this.tnumber=tnumber;
        this.description=description;
        this.prov=prov;
        this.paroxes=paroxes;
        this.reviews=new HashMap<>();
        this.stars=new HashMap<>();
        this.dates=new HashMap<>();
    }


    /**
     *setter
     * @param name/ το όνομα
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * setter
     * @param type/τύπος
     */
    public void setType(String type){
        this.type=type;
    }
    /**
     * setter
     * @param dief/διευθυνση
     */
    public void setDief(String dief){
        this.dief=dief;
    }
    /**
     * setter
     * @param city/πόλη
     */
    public void setCity(String city){
        this.city=city;
    }
    /**
     * setter
     * @param tnumber/ταχυδρομικος κώδικας
     */
    public void setTnumber(String tnumber){
        this.tnumber=tnumber;
    }
    /**
     * setter
     * @param description/περιγραφή
     */
    public void setDescription(String description){
        this.description=description;
    }
    /**
     * setter
     * @param prov/πάροχος
     */
    public void setProvider(Provider prov){
        this.prov=prov;
    }

    /**
     * setter
     * @param paroxes/παροχές
     */
    public void setParoxes(ArrayList<String> paroxes){
        this.paroxes=paroxes;
    }

    /**
     * getter
     * @return type/τύπος
     */
    public String getType(){return type;}
    /**
     * getter
     * @return dief/διευθυνση
     */
    public String getDief(){
        return dief;
    }
    /**
     * getter
     * @return city/πόλη
     */
    public String getCity(){
        return city;
    }
    /**
     * getter
     * @return tnumber /ταχθδρομικός κώδικας
     */
    public String getTnumber(){
        return tnumber;
    }
    /**
     * getter
     * @return description/περιγραφή
     */
    public String getDescription(){
        return description;
    }
    /**
     * getter
     * @return prov/πάροχος
     */
    public Provider getProvider(){
        return prov;
    }
    /**
     * getter
     * @return paroxes/παροχές
     */
    public ArrayList<String> getParoxes(){
        return paroxes;
    }
    /**
     * getter
     * @return name/όνομα
     */
    public String getName(){return name;}
    /**
     * getter
     * @return stars/αστέρια δωματίου
     */
    public HashMap<String, Integer> getStars() {
        return stars;
    }
    /**
     * getter
     * @return reviews/αξιολογήσεις
     */
    public HashMap<String, String> getReviews() {
        return reviews;
    }
    /**
     * getter
     * @return date/ημερομηνία αξιολόγησης
     */
    public HashMap<String, String> getDate() {
        return dates;
    }



    /**
     * μέθοδος για την αλλαγή καταλήματος
     * @param name
     * @param type
     * @param dief
     * @param city
     * @param tnumber
     * @param description
     * @param paroxes
     */
    public void changeRoom(String name, String type, String dief, String city, String tnumber, String description, ArrayList<String> paroxes){
        this.setName(name);
        this.setType(type);
        this.setDief(dief);
        this.setCity(city);
        this.setTnumber(tnumber);
        this.setDescription(description);
        this.setParoxes(paroxes);
    }

    /**
     * μέθοδος για την προσθήκη κρητικής
     * @param name
     * @param review
     * @param star
     * @param date
     */
    public void addreview(String name,String review,int star,String date) {
        reviews.put(name, review);
        stars.put(name, star);
        dates.put(review, date);
    }


    /**
     * μέθοδος για την αλλαγή κρητικής
     * @param name
     *
     */
    public void removereview(String name){
        dates.remove(reviews.get(name));
        reviews.remove(name);
        stars.remove(name);
    }


    }





