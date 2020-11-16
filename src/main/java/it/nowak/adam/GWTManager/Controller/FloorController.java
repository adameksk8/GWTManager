package it.nowak.adam.GWTManager.Controller;
import it.nowak.adam.GWTManager.Model.Locations.Building;
import it.nowak.adam.GWTManager.Model.Locations.Floor;
import it.nowak.adam.GWTManager.Model.Locations.FloorRepository;
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
public class FloorController {

    @Autowired
    private FloorRepository floorRepository;

    @GetMapping("/floors")
    public List<Floor> getAllFloors() {return floorRepository.findAll();}
    @GetMapping("/floors/{id}")
    public ResponseEntity<Floor> getFloorsById(@PathVariable(value = "id") Long floorId) throws ResourceNotFoundException {
        it.nowak.adam.GWTManager.Model.Locations.Floor floor =
                floorRepository
                        .findById(floorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Floor not found on :: " + floorId));
        return ResponseEntity.ok().body(floor);
    }
    @PostMapping("/floors")
    public Floor createFloor(@Valid @RequestBody Floor floor) { return floorRepository.save(floor);}
    @PutMapping("/floors/{id}")
    public ResponseEntity<Floor> updateFloor(

            @PathVariable(value = "id") Long floorId, @Valid @RequestBody Floor floorDetails)
            throws ResourceNotFoundException {
        Floor floor =
                floorRepository
                        .findById(floorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Floor not found on :: " + floorId));
        floor.setLevel(floorDetails.getLevel());
        floor.setBuilding(floorDetails.getBuilding());
        final Floor updatedFloor = floorRepository.save(floor);
        return ResponseEntity.ok(updatedFloor);
    }
    @DeleteMapping("/floors/{id}")
    public Map<String, Boolean> deleteFloor(@PathVariable(value = "id") Long floorId) throws Exception {
        Floor floor =
                floorRepository
                        .findById(floorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Floor not found on :: " + floorId));
        floorRepository.delete(floor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

