package it.nowak.adam.GWTManager.Model.Devices;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ROUTERS")
@EntityListeners(AuditingEntityListener.class)
public class Router extends NetworkDevice {
    private String producer;
    private String model;
    private String adName;
    @OneToMany
    private Set<SwitchPort> ports;

    public Router() {
        super();
    }
    public long getId() {
        return super.getId();
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getAdName() {
        return adName;
    }
    public void setAdName(String adName) {
        this.adName = adName;
    }
}
