package it.nowak.adam.GWTManager.Model.Devices;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="SWITCH")
@EntityListeners(AuditingEntityListener.class)
public class Switch extends NetworkDevice {
    private String producer;
    private String model;
    @OneToMany
    private Set<SwitchPort> ports;

    public Switch() {
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
}
