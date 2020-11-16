package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.DataGenerators.UsersGenerator;
import it.nowak.adam.GWTManager.Model.Devices.Computer;
import it.nowak.adam.GWTManager.Model.Devices.ComputerRepository;
import it.nowak.adam.GWTManager.Model.Devices.Device;
import it.nowak.adam.GWTManager.Model.Devices.DeviceRepository;
import it.nowak.adam.GWTManager.Model.Users.User;
import it.nowak.adam.GWTManager.Model.Users.UserRepository;
import it.nowak.adam.GWTManager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/generate/")
    public List<User> generateUser() {
        UsersGenerator generator = new UsersGenerator();
        userRepository.saveAll(generator.generateUsers(1000));
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users/{id}/computers")
    public ResponseEntity<List<Computer>> getComputersByOwnerId(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        List<Computer> computers = computerRepository.findAll();
        List<Computer>result=computers.stream().filter(computer->computer.getOwner().equals(user)).collect((Collectors.toList()));

        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/users/{id}/devices")
    public ResponseEntity<List<Device>> getDevicesByOwnerId(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        List<Device> devices = deviceRepository.findAll();
        List<Device>result=devices.stream().filter(device->device.getOwner().equals(user)).collect((Collectors.toList()));

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(

            @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
            throws ResourceNotFoundException {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        user.setPhone(userDetails.getPhone());
        user.setMobilePhone(userDetails.getMobilePhone());
        user.setVoip(userDetails.getVoip());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}