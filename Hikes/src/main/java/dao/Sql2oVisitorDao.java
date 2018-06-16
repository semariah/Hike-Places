package dao;

import models.Visitor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2o.*;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oVisitorDao implements VisitorDao{

    private final Sql2o sql2o;

    public Sql2oVisitorDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    
    
    
    @Override
    public List<Visitor> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM visitors")
                    .executeAndFetch(Visitor.class);
        }
    }

    @Override
    public void add(Visitor visitor) {
        String sql = "INSERT INTO visitors (name) VALUES (:name)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(visitor)
                    .executeUpdate()
                    .getKey();
            visitor.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public Visitor findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM visitors WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Visitor.class);
        }
    }

    @Override
    public void update(int id, String name) {
        String sql = "UPDATE visitors SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from visitors WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAllVisitors() {
        String sql = "DELETE from visitors";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
