package it.nowak.adam.GWTManager.Model.Locations;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "FLOORS")
public class Floor {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    Building building;
    @OneToMany
    List<Room> rooms;
    private String level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
