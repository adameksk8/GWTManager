package it.nowak.adam.GWTManager.Model.Locations;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "FLOORS")
public class Floor {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    Building building;
    @OneToMany
    List<Room> rooms;
}
