package it.nowak.adam.GWTManager.Model.Locations;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BUILDINGS")
public class Building {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    Site site;
    @OneToMany
    List<Floor> floors;
}
