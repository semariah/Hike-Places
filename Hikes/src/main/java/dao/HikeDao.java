package dao;

import models.Hike;
import java.util.List;

public interface HikeDao {

    //List
    List<Hike> getAll();

    //create
    void add(Hike hike);

    //Read
    Hike findById(int id);

    //Update
    //void update(int id, name, hikeLength, state)

    // Delete
    //void deleteById(int id);
    //void clearAllHikes();
}
