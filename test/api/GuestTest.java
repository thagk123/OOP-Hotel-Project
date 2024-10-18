package api;
import api.Guest;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.ArrayList;

public class GuestTest {

    @Test
    public void getUsername() {
        Guest a = new Guest("Θάνος", "Γκουτής", "tgout", "abc", "Guest");
        String username=a.getUsername();
        assertEquals("tgout",username);
    }

    @Test
    public void getPassword() {
        Guest a = new Guest("Θάνος", "Γκουτής", "tgout", "abc", "Guest");
        String password=a.getPassword();
        assertEquals("abc",password);
    }

    @Test
    public void getType() {
        Guest a = new Guest("Θάνος", "Γκουτής", "tgout", "abc", "Guest");
        String type=a.getType();
        assertEquals("Guest",type);
    }

    @Test
    public void addReview() {
        Guest a = new Guest("Θάνος", "Γκουτής", "tgout", "abc", "Guest");
        a.addReview("Lucy Hotel","Όμορφο ήταν",3,"2/1/2023");
        a.addReview("Makedonia Palace","Μου άρεσε",3,"6/1/2023");
        int num=a.getReviews().size();
        assertEquals(2,num);
    }


    @Test
    public void getDates() {
        Guest a = new Guest("Θάνος", "Γκουτής", "tgout", "abc", "Guest");
        Provider x=new Provider("Dim","Kag","DK","123","Provider");
        ArrayList<String> par=new ArrayList<>();
        Room room=new Room("Lucy Hotel", "Ξενοδοχείο", "Παπαγεωργίου 122", "Καβάλα", "12554", "Με θεα την θάλασσα και την πανέμορφη Θάσο",x,par);
        String review="Όμορφο ήταν";
        room.addreview("Lucy Hotel",review,3,"2/1/2023");
        String review2="Μου άρεσε";
        room.addreview("Lucy Hotel",review2,4,"6/1/2023");
        HashMap<String,String> dates=room.getDate();
        assertEquals(2,dates.keySet().size());
    }
}