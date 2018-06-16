package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class VisitorTest {

    @Test
    public void getNameGetsNameCorrectly() {
        Visitor visitor = setupNewVisitor();
        visitor.setName("semhar");
        assertEquals("semhar", visitor.getName());
    }

    @Test
    public void getIdGetsIdCorrectly() {
        Visitor visitor = setupNewVisitor();
        visitor.setId(1);
        assertEquals(1, visitor.getId());
    }

    private Visitor setupNewVisitor() {
        return new Visitor("semhar");
    }
}
