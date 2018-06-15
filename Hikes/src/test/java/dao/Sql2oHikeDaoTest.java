package dao;

import models.Hike;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;

public class Sql2oHikeDaoTest {
    private Sql2oHikeDao hikeDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        hikeDao = new Sql2oHikeDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();

    }

    @Test
    public void addingHikesSetsId() throws Exception{
        Hike hike = setupNewHike();
        int originalHikeId = hike.getId();
        hikeDao.add(hike);
        assertNotEquals(originalHikeId, hike.getId());
    }

    @Test
    public void existingHikesFoundById() throws Exception {
        Hike hike = setupNewHike();
        hikeDao.add(hike);
        Hike foundHike = hikeDao.findById(hike.getId());
        assertEquals(foundHike, hike);
    }

    @Test
    public void getAllGetsAllAddedHikes() {
        Hike hike = setupNewHike();
        hikeDao.add(hike);
        assertEquals(1, hikeDao.getAll().size());
    }

    private Hike setupNewHike() {
        return new Hike("semhar", 2, "oregon");
    }
}
