package it.nowak.adam.GWTManager.Model.Locations;


import it.nowak.adam.GWTManager.Model.Devices.Device;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROOMS")
public class Room {

    @Id
    @GeneratedValue
    private long id ;
    @ManyToOne
    Floor floor;
    @OneToMany
    Set<Device> devices;
    private String number;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", floor=" + floor +
                ", devices=" + devices +
                ", number='" + number + '\'' +
                '}';
    }
}
