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
    Set<Device> devices = new HashSet<>();
}
