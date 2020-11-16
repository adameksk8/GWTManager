package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Devices.Computer;
import it.nowak.adam.GWTManager.Model.Devices.Device;
import it.nowak.adam.GWTManager.Model.Devices.DeviceRepository;
import it.nowak.adam.GWTManager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/devices")
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @DeleteMapping("/devices/{id}")
    public Map<String, Boolean> deleteDevice(@PathVariable(value = "id") Long deviceId) throws Exception {
        Device device =
                deviceRepository
                        .findById(deviceId)
                        .orElseThrow(() -> new ResourceNotFoundException("Device not found on :: " + deviceId));
        deviceRepository.delete(device);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}