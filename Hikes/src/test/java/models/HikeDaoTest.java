package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HikeDaoTest {
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
        assertEquals(2, hike.getHikeLength());
    }

    @Test
    public void getStateGetsStateCorrectly() throws Exception {
        Hike hike = setupNewHike();
        hike.setState();
        assertEquals("oregon", hike.getState());
    }

    @Test
    public void getIdGetsIdCorrectly() throws Exception {
        Hike hike = setupNewHike();
        hike.setId(1);
        assertEquals(1, hike.getId());
    }


    private Hike setupNewHike() {
        return new Hike("multnomah falls", 2, "oregon");
    }
}
