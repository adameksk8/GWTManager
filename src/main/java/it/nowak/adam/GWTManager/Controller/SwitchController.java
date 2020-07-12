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

        _switch.setDescription(_switch.getDescription());
        _switch.setDeviceId(_switch.getDeviceId());
        _switch.setIpAddress(_switch.getIpAddress());
        _switch.setMacAddress(_switch.getMacAddress());
        _switch.setModel(_switch.getModel());
        _switch.setProducer(_switch.getProducer());
        _switch.setRoom(_switch.getRoom());
        _switch.setAdName(_switch.getAdName());
        final Switch updatedSwitch = switchRepository.save(_switch);
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
