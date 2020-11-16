package it.nowak.adam.GWTManager.Model.Users;

import it.nowak.adam.GWTManager.Model.Devices.Device;
import it.nowak.adam.GWTManager.Model.Locations.Room;
import it.nowak.adam.GWTManager.Model.Locations.Site;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Entity
@Table(name="USERS")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column
    @NotNull
    private String firstName;
    @Column
    @NotNull
    private String lastName;
    @Column
    @NotNull
    private String email;
    @NotNull
    private long pesel;
    @Column
    @NotNull
    private String role;
    @Column
    private String phone;
    @Column
    private String mobilePhone;
    @Column
    private String voip;
    @ManyToMany(mappedBy = "usedBy")
    private Set<Device> usesDevices = new HashSet<>();
    //@OneToMany (mappedBy = "owner")
    //private Set<Device> ownsDevices = new HashSet<>();
    @ManyToOne
    private Site site;
    @ManyToOne
    private Room room;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getPesel() {
        return pesel;
    }
    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
    public String getRole() {
        return this.getClass().getSimpleName();

    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getVoip() {
        return voip;
    }
    public void setVoip(String voip) {
        this.voip = voip;
    }
    public Set<Long> getUsesDevices() {
        Set<Long> result  = new HashSet<>();
        this.usesDevices.forEach(device -> result.add(device.getId()));
        return result;
    }
    public void setUsesDevices(Set<Device> usesDevices) {
        this.usesDevices = usesDevices;
    }

    /*public Set<Long> getOwnsDevices() {
        Set<Long> result  = new HashSet<>();
        this.ownsDevices.forEach(device -> result.add(device.getId()));
        return result;
    }
    public void setOwnsDevices(Set<Device> ownsDevices) {
        this.usesDevices = ownsDevices;
    }*/

    public Site getSite() {
        return site;
    }
    public void setSite(Site site) {
        this.site = site;
    }
}

