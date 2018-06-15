package models;

import java.util.Objects;

public class Hike {

    private String name;
    private int hikeLength;
    private  String state;
    private int  id;

    public Hike(String name, int hikeLength, String state) {
        this.name = name;
        this.hikeLength = hikeLength;
        this.state = state;
    }

    public void setName() {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setHikeLength() {
        this.hikeLength = hikeLength;
    }

    public int getHikeLength() {
        return hikeLength;
    }

    public void setState() {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hike hike = (Hike) o;
        return hikeLength == hike.hikeLength &&
                id == hike.id &&
                Objects.equals(name, hike.name) &&
                Objects.equals(state, hike.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, hikeLength, state, id);
    }
}
