package dao;

import models.Hike;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oHikeDao implements HikeDao{
    private final Sql2o sql2o;

    public Sql2oHikeDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Hike> getAll() {
        return null;
    }

    @Override
    public void add(Hike hike) {

    }

    @Override
    public Hike findById(int id) {
        return null;
    }
}
