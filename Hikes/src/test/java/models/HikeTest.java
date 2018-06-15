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
        assertEquals(true, hike instanceof  Hike);
    }

    @Test
    public void getNameGetsNameCorrectly() throws Exception {
        Hike hike = setupNewHike();
        hike.setName();
        assertEquals("multnomah falls", hike.getName());
    }

    @Test
    public void getHikeLengthGetsLengthCorrectly() throws Exception {
        Hike hike = setupNewHike();
        hike.setHikeLength();
        assertNotEquals(2, hike.getHikeLength());
    }

    private Hike setupNewHike() {
        return new Hike("multnomah falls", 2, "oregon");
    }
}
