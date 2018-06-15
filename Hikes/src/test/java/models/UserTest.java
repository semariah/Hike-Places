package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getNameGetsNameCorrectly() {
        User user = setupNewUser();
        user.setName("semhar");
        assertEquals("semhar", user.getName());
    }

    private User setupNewUser() {
        return new User ("semhar", 1);
    }
}
