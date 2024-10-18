package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getUsername() {
        User a=new User("Γιούλη", "Γκουτή", "gioulg", "456", "Provider");
        String username=a.getUsername();
        assertEquals("gioulg",username);
    }

    @Test
    public void getPassword() {
        User a=new User("Γιούλη", "Γκουτή", "gioulg", "456", "Provider");
        String password=a.getPassword();
        assertEquals("456",password);
    }

    @Test
    public void getType() {
        User a=new User("Γιούλη", "Γκουτή", "gioulg", "456", "Provider");
        String type=a.getType();
        assertEquals("Provider",type);
    }


}