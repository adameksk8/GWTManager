package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Locations.Building;
import it.nowak.adam.GWTManager.Model.Locations.BuildingRepository;
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
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }
    @GetMapping("/buildings/{id}")
    public ResponseEntity<it.nowak.adam.GWTManager.Model.Locations.Building> getBuildingsById(@PathVariable(value = "id") Long buildingId) throws ResourceNotFoundException {
        it.nowak.adam.GWTManager.Model.Locations.Building building =
                buildingRepository
                        .findById(buildingId)
                        .orElseThrow(() -> new ResourceNotFoundException("Building not found on :: " + buildingId));
        return ResponseEntity.ok().body(building);
    }
    @PostMapping("/buildings")
    public Building createBuilding(@Valid @RequestBody Building building) { return buildingRepository.save(building);}
    @PutMapping("/buildings/{id}")
    public ResponseEntity<Building> updateBuilding(

            @PathVariable(value = "id") Long buildingId, @Valid @RequestBody Building buildingDetails)
            throws ResourceNotFoundException {
        Building building =
                buildingRepository
                        .findById(buildingId)
                        .orElseThrow(() -> new ResourceNotFoundException("Building not found on :: " + buildingId));

     building.setNumber(buildingDetails.getNumber());
     building.setSite(buildingDetails.getSite());
    // building.setFloors(buildingDetails.getFloors());
        final Building updatedBuilding = buildingRepository.save(building);
        return ResponseEntity.ok(updatedBuilding);
    }
    @DeleteMapping("/buildings/{id}")
    public Map<String, Boolean> deleteBuilding(@PathVariable(value = "id") Long buildingId) throws Exception {
        Building building =
                buildingRepository
                        .findById(buildingId)
                        .orElseThrow(() -> new ResourceNotFoundException("Building not found on :: " + buildingId));
        buildingRepository.delete(building);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
