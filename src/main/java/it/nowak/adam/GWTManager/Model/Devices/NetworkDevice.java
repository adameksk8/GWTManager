package it.nowak.adam.GWTManager.Model.Devices;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "NETWORK_DEVICE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class NetworkDevice extends Device {
    private String ipAddress;
    private String macAddress;

    public NetworkDevice() {
        super();
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
