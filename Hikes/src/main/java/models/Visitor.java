package models;

import java.util.Objects;

public class Visitor {
    private String name;
    private int id;

    public Visitor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return id == visitor.id &&
                Objects.equals(name, visitor.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }
}
