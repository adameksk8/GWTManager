package it.nowak.adam.GWTManager.Model.Devices;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="SWITCHPORTS")
@EntityListeners(AuditingEntityListener.class)
public class SwitchPort {

    @Id
    @GeneratedValue
    private long id ;
    private String portName;
    private String portMode;
    private String portType;
    private Integer portBandwidth;
    @ManyToOne
    private Switch parentSwitch;

    public long getId() {
        return id;
    }
    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortMode() {
        return portMode;
    }

    public void setPortMode(String portMode) {
        this.portMode = portMode;
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    public Integer getPortBandwidth() {
        return portBandwidth;
    }

    public void setPortBandwidth(Integer portBandwidth) {
        this.portBandwidth = portBandwidth;
    }
}

