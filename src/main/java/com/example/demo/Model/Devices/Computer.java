package com.example.demo.Model.Devices;

import com.example.demo.Model.Locations.Room;
import com.example.demo.Model.Users.User;

import java.util.List;

public class Computer extends NetworkDevice {
    private String producer;
    private String model;

    public Computer(long id, int du, String description, User owner, List<User> users, Room location, String serialNumber, int deviceId, String ipAddress, String macAddress, String producer, String model) {
        super(id, du, description, owner, users, location, serialNumber, deviceId, ipAddress, macAddress);
        this.producer = producer;
        this.model = model;
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
