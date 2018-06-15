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

    @Test
    public void getIdGetsIdCorrectly() {
        User user = setupNewUser();
        user.setId(1);
        assertEquals("semhar", user.getId());
    }

    private User setupNewUser() {
        return new User ("semhar", 1);
    }
}
