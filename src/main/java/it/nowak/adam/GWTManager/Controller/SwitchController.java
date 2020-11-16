package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Devices.SwitchRepository;
import it.nowak.adam.GWTManager.Model.Devices.Switch;
import it.nowak.adam.GWTManager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SwitchController {

    @Autowired
    private SwitchRepository switchRepository;

    @GetMapping("/switches")
    public List<Switch> getAllSwitches() {
        return switchRepository.findAll();
    }

    @GetMapping("/switches/{id}")
    public ResponseEntity<Switch> getSwitchesById(@PathVariable(value = "id") Long switchId) throws ResourceNotFoundException {
        Switch _switch =
                switchRepository
                        .findById(switchId)
                        .orElseThrow(() -> new ResourceNotFoundException("Switch not found on :: " + switchId));
        return ResponseEntity.ok().body(_switch);
    }

    @PostMapping("/switches")
    public Switch createSwitch(@Valid @RequestBody Switch _switch) { return switchRepository.save(_switch);}

    @PutMapping("/switches/{id}")
    public ResponseEntity<Switch> updateSwitch(

            @PathVariable(value = "id") Long switchId, @Valid @RequestBody Switch switchDetails)
            throws ResourceNotFoundException {
        Switch _switch =
                switchRepository
                        .findById(switchId)
                        .orElseThrow(() -> new ResourceNotFoundException("Switch not found on :: " + switchId));

        _switch.setDescription(switchDetails.getDescription());
        _switch.setDeviceId(switchDetails.getDeviceId());
        _switch.setIpAddress(switchDetails.getIpAddress());
        _switch.setMacAddress(switchDetails.getMacAddress());
        _switch.setModel(switchDetails.getModel());
        _switch.setProducer(switchDetails.getProducer());
        _switch.setRoom(switchDetails.getRoom());
        final Switch updatedSwitch = switchRepository.save(switchDetails);
        return ResponseEntity.ok(updatedSwitch);
    }
    @DeleteMapping("/switches/{id}")
    public Map<String, Boolean> deleteSwitch(@PathVariable(value = "id") Long switchId) throws Exception {
        Switch _switch =
                switchRepository
                        .findById(switchId)
                        .orElseThrow(() -> new ResourceNotFoundException("Switch not found on :: " + switchId));
        switchRepository.delete(_switch);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
