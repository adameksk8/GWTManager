package it.nowak.adam.GWTManager.Model.Users;

import it.nowak.adam.GWTManager.Model.Devices.Device;
import it.nowak.adam.GWTManager.Model.Locations.Site;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USERS")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(name="first_name", nullable = false, length=30)
    private String firstName;
    @Column(name="last_name", nullable = false, length=40)
    private String lastName;
    @Column(name="email", nullable = false, length=50)
    private String email;
    @Column(name="role", nullable = false )
    private String role;
    @ManyToMany
    private Set<Device> usesDevices = new HashSet<>();
    @ManyToOne
    private Site site;

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

    public String getRole() {
        return this.getClass().getName();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Device> getUsesDevices() {
        return usesDevices;
    }

    public void setUsesDevices(Set<Device> usesDevices) {
        this.usesDevices = usesDevices;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}

