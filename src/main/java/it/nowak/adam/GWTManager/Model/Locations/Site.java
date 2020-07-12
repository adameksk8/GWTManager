package it.nowak.adam.GWTManager.Model.Locations;

import it.nowak.adam.GWTManager.Model.Users.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="SITES")
@EntityListeners(AuditingEntityListener.class)

public class Site {
    @Id
    @GeneratedValue
    private long id;
    private long siteId;
    private String name;
    @OneToMany
    Set<User> users = new HashSet<>();
    @OneToMany
    Set<Building> buildings = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }
}
