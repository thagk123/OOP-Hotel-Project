package api;

import java.io.Serializable;


/**
 * κλάση που αναπαριστά έναν χρήστη
 * @author  Δημήτριος Καγγελίδης
 */
public class User implements Serializable {

    private String name;//όνομα
    private String surname;//επίθετο
    private String username;//όνομα χρήστη
    private String password;//κωδικός
    private String type;//τύπος χρήστη



    /**
     * κατασκευαστής της User
     * @param name
     * @param surname
     * @param username
     * @param password
     * @param type
     */
    public User(String name,String surname,String username,String password,String type){

        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.type=type;
    }

    /**
     * getter
     * @return username/όνομα χρήστη
     */
    public String getUsername() {
        return username;
    }

    /**
     * getter
     * @return password/κωδικός χρήστη
     */
    public String getPassword(){
        return password;
    }

    /**
     * getter
     * @return type/τύπος χρήστη
     */
    public String getType(){
        return type;
    }


    }




