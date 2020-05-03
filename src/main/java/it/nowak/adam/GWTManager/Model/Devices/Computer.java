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
    private int hdd;

    public long getId() {
        return super.getId();
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    private int ram;
    private String cpu;

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

    public String getOwnerName(){return this.getOwner().getFirstName()+" "+this.getOwner().getLastName();};


}
