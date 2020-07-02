package it.nowak.adam.GWTManager.Model.Devices;

import it.nowak.adam.GWTManager.Model.Locations.Room;
import it.nowak.adam.GWTManager.Model.Users.User;
import it.nowak.adam.GWTManager.Model.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table (name = "DEVICE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {

    @Id
    @GeneratedValue
    private long id ;
    private String description;
    @ManyToOne
    private User owner;
    @ManyToOne
    private Room room;
    @Column
    private String serialNumber;
    @Column
    private Integer deviceId;
    @ManyToMany//(mappedBy = "usesDevices")
    private Set<User> usedBy = new HashSet<>();
    public long getId() {
        return id;
    }
    public long getIdentifier() {
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
    public Integer getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
    public Set<User> getUsedBy() {
        return usedBy;
    }
    public void setUsedBy(Set<User> usedBy) {
        this.usedBy = usedBy;
    }
    public String getDeviceType(){
        return this.getClass().getSimpleName();}
}
