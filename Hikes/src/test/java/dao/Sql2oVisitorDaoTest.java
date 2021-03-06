package dao;
import models.Visitor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.*;
import org.junit.*;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class Sql2oVisitorDaoTest {
    private Sql2oVisitorDao visitorDao;
    private Sql2oHikeDao hikeDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        visitorDao = new Sql2oVisitorDao(sql2o);
        hikeDao = new Sql2oHikeDao(sql2o);
        conn = sql2o.open(); 
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }


    @Test
    public void addingVisitorsSetsId() throws Exception{
        Visitor visitor = setupNewVisitor();
        int originalVisitorId = visitor.getId();
        visitorDao.add(visitor);
        assertNotEquals(originalVisitorId, visitor.getId());
    }

    @Test
    public void existingVisitorsFoundById() throws Exception {
        Visitor visitor = setupNewVisitor();
        visitorDao.add(visitor);
        Visitor foundVisitor = visitorDao.findById(visitor.getId());
        assertEquals(foundVisitor, visitor);
    }

    @Test
    public void getAllGetsAllAddedVisitors() {
        Visitor visitor = setupNewVisitor();
        visitorDao.add(visitor);
        assertEquals(1, visitorDao.getAll().size());
    }

    @Test
    public void noVisitorsReturnsEmptyList() throws Exception {
        assertEquals(0, visitorDao.getAll().size());
    }


    @Test
    public void updateChangesVisitorName() throws Exception {
        String initialName = "janet";
        Visitor visitor = setupNewVisitor();
        visitorDao.add(visitor);
        visitorDao.update(visitor.getId(), "betty");
        Visitor updatedVisitor = visitorDao.findById(visitor.getId());
        assertNotEquals(initialName, updatedVisitor.getName());
    }


    @Test
    public void deleteByIdDeletesCorrectVisitor() throws Exception {
        Visitor visitor = setupNewVisitor();
        visitorDao.add(visitor);
        visitorDao.deleteById(visitor.getId());
        assertEquals(0, visitorDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Visitor visitor = setupNewVisitor();
        Visitor otherVisitor = setupNewVisitor();
        visitorDao.add(visitor);
        visitorDao.add(otherVisitor);
        int daoSize = visitorDao.getAll().size();
        visitorDao.clearAllVisitors();
        assertTrue(daoSize>0 && daoSize > visitorDao.getAll().size());
    }

    
    private Visitor setupNewVisitor() {
        return new Visitor("betty");
    }
}
