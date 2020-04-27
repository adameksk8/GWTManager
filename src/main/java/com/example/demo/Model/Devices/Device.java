package com.example.demo.Model.Devices;

import com.example.demo.Model.Locations.Room;
import com.example.demo.Model.Users.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "DEVICE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {


    @Id
    @GeneratedValue
    private long id ;
    private String description;
    private User owner;
    @OneToMany
    private Set<User> users;
    private Room location;
    @Column(name = "serial_number")
    private String serialNumber;
    private int deviceId;


    public Device(long id, int du, String description, User owner, Set<User> users, Room location, String serialNumber, int deviceId) {
        this.id = id;
        this.description = description;
        this.owner = owner;
        this.users = users;
        this.location = location;
        this.serialNumber = serialNumber;
        this.deviceId = deviceId;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
