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
        assertEquals(1, user.getId());
    }

    private User setupNewUser() {
        return new User ("semhar", 1);
    }
}
