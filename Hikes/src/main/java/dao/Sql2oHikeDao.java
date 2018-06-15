package dao;

import models.Hike;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oHikeDao implements HikeDao{
    private final Sql2o sql2o;

    public Sql2oHikeDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Hike> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM hikes")
                    .executeAndFetch(Hike.class);
        }
    }

    @Override
    public void add(Hike hike) {
        String sql = "INSERT INTO hikes (name, hikeLength, state) VALUES (:name, :hikeLength, :state)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(hike)
                    .executeUpdate()
                    .getKey();
            hike.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }


    }

    @Override
    public Hike findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM hikes WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Hike.class);
        }
    }

    @Override
    public void update(int id, String name, int hikeLength, String state) {
        String sql = "UPDATE hikes SET (name, hikeLength, sate) = (:name, :hikeLength, :state) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("hikeLength",  hikeLength)
                    .addParameter("state", state)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from hikes WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAllHikes() {
        String sql = "DELETE from hikes";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }




}
