package api;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProviderTest {

    @Test
    public void getUsername() {
        Provider x=new Provider("Dim","Kag","DK","123","Provider");
        assertEquals(x.getUsername(),"DK");
    }

    @Test
    public void getPassword() {
        Provider x=new Provider("Dim","Kag","DK","123","Provider");
        assertEquals(x.getPassword(),"123");
    }

    @Test
    public void getType() {

        Provider x=new Provider("Dim","Kag","DK","123","Provider");
        assertEquals(x.getType(),"Provider");
    }

    @Test
    public void addRoom() {
        Provider x=new Provider("Dim","Kag","DK","123","Provider");
        ArrayList<String> par=new ArrayList<>();
        x.addRoom("Makedonia","Ξενοδοχείο","Aristotelous","Thessaloniki","123","Poli Oraio",par);
        x.addRoom("Makedon","Ξενοδοχείο","Aristotelous","Thessaloniki","456","Poli Oraio",par);
        ArrayList<Room> a=x.getRooms();
        assertEquals(2,a.size());
    }
    
    @Test
    public void getRooms(){
        Provider x=new Provider("Dim","Kag","DK","123","Provider");
        ArrayList<String> par=new ArrayList<>();
        x.addRoom("Makedonia","Ξενοδοχείο","Aristotelous","Thessaloniki","123","Poli Oraio",par);
        ArrayList<Room> a=x.getRooms();
        assertEquals(1,a.size());
    }
}