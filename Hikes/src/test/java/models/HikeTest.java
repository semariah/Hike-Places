package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HikeTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void hikeInstantiatesCorrectly() throws Exception {
        Hike hike = setupNewHike();
        assertNotEquals(true, hike instanceof  Hike);
    }

    private Hike setupNewHike() {
        return new Hike("multnomah falls", 2, "oregon");
    }
}
