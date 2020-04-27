package com.example.demo.Model.Locations;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="site")
@EntityListeners(AuditingEntityListener.class)

public class Site {
    @Id
    @GeneratedValue
    private long id;

  //  @OneToMany
   // Set<Building> buildings = new HashSet<>();
}
