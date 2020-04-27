package com.example.demo.Model.Devices;

import com.example.demo.Model.Devices.Device;
import com.example.demo.Model.Locations.Room;
import com.example.demo.Model.Users.User;

import java.util.List;

public abstract class NetworkDevice extends Device {
    private String ipAddress;
    private String macAddress;

    public NetworkDevice(long id, int du, String description, User owner, List<User> users, Room location, String serialNumber, int deviceId, String ipAddress, String macAddress) {
        super(id, du, description, owner, users, location, serialNumber, deviceId);
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
