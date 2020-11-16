package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Devices.Router;
import it.nowak.adam.GWTManager.Model.Devices.RouterRepository;
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
public class RouterController {

    @Autowired
    private RouterRepository routerRepository;

    @GetMapping("/routers")
    public List<Router> getAllRouters() {
        return routerRepository.findAll();
    }
    @GetMapping("/routers/{id}")
    public ResponseEntity<Router> getRoutersById(@PathVariable(value = "id") Long routerId) throws ResourceNotFoundException {
        Router router =
                routerRepository
                        .findById(routerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Router not found on :: " + routerId));
        return ResponseEntity.ok().body(router);
    }

    @PostMapping("/routers")
    public Router createRouter(@Valid @RequestBody Router router) { return routerRepository.save(router);}

    @PutMapping("/routers/{id}")
    public ResponseEntity<Router> updateComputer(

            @PathVariable(value = "id") Long routerId, @Valid @RequestBody Router routerDetails)
            throws ResourceNotFoundException {
        Router router =
                routerRepository
                        .findById(routerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Router not found on :: " + routerId));

        router.setDescription(routerDetails.getDescription());
        router.setDeviceId(routerDetails.getDeviceId());
        router.setIpAddress(routerDetails.getIpAddress());
        router.setMacAddress(routerDetails.getMacAddress());
        router.setModel(routerDetails.getModel());
        router.setProducer(routerDetails.getProducer());
        router.setRoom(routerDetails.getRoom());
        final Router updatedRouter = routerRepository.save(router);
        return ResponseEntity.ok(updatedRouter);
    }
    @DeleteMapping("/routers/{id}")
    public Map<String, Boolean> deleteRouter(@PathVariable(value = "id") Long routerId) throws Exception {
        Router router =
                routerRepository
                        .findById(routerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Router not found on :: " + routerId));
        routerRepository.delete(router);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
