package it.nowak.adam.GWTManager.Model.Devices;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name="COMPUTERS")
@EntityListeners(AuditingEntityListener.class)
public class Computer extends NetworkDevice {
    private String producer;
    private String model;
    private String hdd;
    private Integer ram;
    private String cpu;
    private String adName;

    public long getId() {
        return super.getId();
    }
    public String getHdd() {
        return hdd;
    }
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
    public Integer getRam() {
        return ram;
    }
    public void setRam(Integer ram) {
        this.ram = ram;
    }
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public Computer() {
        super();
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
