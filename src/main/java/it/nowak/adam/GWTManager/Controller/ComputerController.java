package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Devices.Computer;
import it.nowak.adam.GWTManager.Model.Devices.ComputerRepository;
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
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepository;

    @GetMapping("/computers")
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    @GetMapping("/computers/{id}")
    public ResponseEntity<Computer> getComputersById(@PathVariable(value = "id") Long computerId) throws ResourceNotFoundException {
        Computer computer =
                computerRepository
                        .findById(computerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Computer not found on :: " + computerId));
        System.out.println(computer);
        return ResponseEntity.ok().body(computer);
    }

    @PostMapping("/computers")
    public Computer createComputer(@Valid @RequestBody Computer computer) {

        return computerRepository.save(computer);
    }

    @PutMapping("/computers/{id}")
    public ResponseEntity<Computer> updateComputer(

            @PathVariable(value = "id") Long computerId, @Valid @RequestBody Computer computerDetails)
            throws ResourceNotFoundException {
        Computer computer =
                computerRepository
                        .findById(computerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Computer not found on :: " + computerId));
        computer.setCpu(computerDetails.getCpu());
        computer.setDescription(computerDetails.getDescription());
        computer.setDeviceId(computerDetails.getDeviceId());
        computer.setHdd(computerDetails.getHdd());
        computer.setIpAddress(computerDetails.getIpAddress());
        computer.setMacAddress(computerDetails.getIpAddress());
        computer.setModel(computerDetails.getModel());
        computer.setProducer(computerDetails.getProducer());
        computer.setRam(computerDetails.getRam());
        computer.setUsers(computerDetails.getUsers());
        computer.setRoom(computerDetails.getRoom());
        //-----------------------zweryfikować i uzupełnić pozostałe atrybuty--------------------------------------------

        final Computer updatedComputer = computerRepository.save(computer);
        return ResponseEntity.ok(updatedComputer);
    }

    @DeleteMapping("/computers/{id}")
    public Map<String, Boolean> deleteComputer(@PathVariable(value = "id") Long computerId) throws Exception {
        Computer computer =
                computerRepository
                        .findById(computerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Computer not found on :: " + computerId));
        computerRepository.delete(computer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
