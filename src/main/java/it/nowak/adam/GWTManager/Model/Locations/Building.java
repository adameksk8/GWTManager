package it.nowak.adam.GWTManager.Model.Locations;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUILDINGS")
public class Building {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    Site site;
    @OneToMany
    Set<Floor> floors = new HashSet<>();
    String number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
