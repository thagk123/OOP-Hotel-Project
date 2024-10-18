package api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class RoomTest {
    @Test
    public void setName(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.setName("Mak");
        assertEquals(r.getName(),"Mak");

    }
    @Test
    public void setType(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.setType("Hotel");
        assertEquals(r.getType(),"Hotel");

    }
    @Test
    public void setDief(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.setDief("Harilaou");
        assertEquals(r.getDief(),"Harilaou");

    }
    @Test
    public void setCity(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.setCity("Thess");
        assertEquals(r.getCity(),"Thess");

    }
    @Test
    public void setTnumber(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.setTnumber("11");
        assertEquals(r.getTnumber(),"11");

    }
    @Test
    public void setDescription(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.setDescription("Poli");
        assertEquals(r.getDescription(),"Poli");

    }
    @Test
    public void setProvider(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        Provider p=new Provider("D","K","Dk","123","Provider");
        r.setProvider(p);
        assertEquals(r.getProvider(),p);

    }
    @Test
    public void setParoxes(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        par.add("Thea");
        r.setParoxes(par);
        assertEquals(r.getParoxes(),par);

    }
    @Test
    public void getType(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getType(),"Hotel");

    }
    @Test
    public void getDief(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getDief(),"Aristotelous");

    }
    @Test
    public void getCity(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getCity(),"Thessaloniki");

    }
    @Test
    public void getTnumber(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getTnumber(),"123");

    }
    @Test
    public void getDescription(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getDescription(),"Poli Oraio");

    }
    @Test
    public void getProvider(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getProvider(),prov);

    }
    @Test
    public void getParoxes(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getParoxes(),par);

    }
    @Test
    public void getName(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        assertEquals(r.getName(),"Makedonia");

    }
    @Test
    public void addreview(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.addreview("D","Oraio",3,"20/1");
        HashMap<String,Integer> a=new HashMap<>();
        a.put("D",3);
        assertEquals(r.getStars(),a);
    }
    @Test
    public void getStars(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.addreview("D","Oraio",4,"1/4");
        HashMap<String,Integer> g=new HashMap<>();
        g.put("D",4);
        assertEquals(g,r.getStars());
    }
    @Test
    public void getReviews(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.addreview("D","Oraio",4,"1/4");
        HashMap<String,String> g=new HashMap<>();
        g.put("D","Oraio");
        assertEquals(g,r.getReviews());
    }
    @Test
    public void getDate(){
        ArrayList<String> par=new ArrayList<String>();
        Provider prov=new Provider("Dim","kag","Dk","123","Provider");
        Room r=new Room("Makedonia","Hotel","Aristotelous","Thessaloniki","123","Poli Oraio",prov,par);
        r.addreview("D","Oraio",4,"1/4");
        HashMap<String,String> g=new HashMap<>();
        g.put("Oraio","1/4");
        assertEquals(g,r.getDate());
    }


}
