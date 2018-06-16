package dao;

import models.Visitor;

import java.util.List;

public interface VisitorDao {

    //LIST
    List<Visitor>getAll();

    //CREATE
    void add(Visitor visitor);

    //READ
    Visitor findById(int id);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllVisitors();
}
