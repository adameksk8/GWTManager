package it.nowak.adam.GWTManager.Model.Devices;

import it.nowak.adam.GWTManager.Model.Locations.Room;
import it.nowak.adam.GWTManager.Model.Users.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "DEVICE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {


    @Id
    @GeneratedValue
    @NotNull
    private long id ;
    private String description;
    @ManyToOne
    private User owner;
    @ManyToMany
    private Set<User> users = new HashSet<>();
    @ManyToOne
    private Room room;
    @Column(name = "serial_number")
    private String serialNumber;
    private int deviceId;


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
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
