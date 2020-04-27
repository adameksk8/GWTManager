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
    private String name;
    @OneToMany
    Set<User> users = new HashSet<>();
    @OneToMany
    Set<Building> buildings = new HashSet<>();
}
