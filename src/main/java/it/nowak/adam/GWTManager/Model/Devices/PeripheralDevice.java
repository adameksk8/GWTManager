package it.nowak.adam.GWTManager.Model.Devices;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PERIPHERAL_DEVICE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PeripheralDevice extends Device {
}

