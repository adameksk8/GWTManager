package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Devices.Computer;
import it.nowak.adam.GWTManager.Model.Devices.ComputerRepository;
import it.nowak.adam.GWTManager.Model.Users.User;
import it.nowak.adam.GWTManager.Model.Users.UserRepository;
import it.nowak.adam.GWTManager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComputerController {
    @Autowired
    private UserRepository userRepository;
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
        computer.setMacAddress(computerDetails.getMacAddress());
        computer.setModel(computerDetails.getModel());
        computer.setProducer(computerDetails.getProducer());
        computer.setRam(computerDetails.getRam());
        computer.setRoom(computerDetails.getRoom());
        computer.setAdName(computerDetails.getAdName());
        final Computer updatedComputer = computerRepository.save(computer);
        return ResponseEntity.ok(updatedComputer);
    }
    @PutMapping("/computers/{id}/addUser/")
    public ResponseEntity<Computer> addUserToComputer (@PathVariable("id")Long id, @RequestParam("userId") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional <Computer> computer = computerRepository.findById(id);
        if (user.isPresent() && computer.isPresent()){
            computer.get().getUsedBy().add(user.get());
        };
        final Computer updatedComputer = computerRepository.save(computer.get());
        System.out.println(updatedComputer.getUsedBy().size());
        return ResponseEntity.ok(updatedComputer);
    }
    @DeleteMapping("/computers/{id}/removeUser/")
    public ResponseEntity<Computer> RemoveUserFromComputer (@PathVariable("id")Long id, @RequestParam("userId") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional <Computer> computer = computerRepository.findById(id);
        if (user.isPresent() && computer.isPresent()){
            computer.get().getUsedBy().remove(user.get());
        };
        final Computer updatedComputer = computerRepository.save(computer.get());
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