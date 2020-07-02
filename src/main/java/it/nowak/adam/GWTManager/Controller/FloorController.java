package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Locations.Floor;
import it.nowak.adam.GWTManager.Model.Locations.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FloorController {

    @Autowired
    private FloorRepository floorRepository;

    @GetMapping("/floors")
    public List<Floor> getAllFloors() {return floorRepository.findAll();}
}

