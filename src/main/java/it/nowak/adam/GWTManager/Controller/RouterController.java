package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Devices.Router;
import it.nowak.adam.GWTManager.Model.Devices.RouterRepository;
import it.nowak.adam.GWTManager.Model.Devices.Switch;
import it.nowak.adam.GWTManager.Model.Devices.SwitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RouterController {

    @Autowired
    private RouterRepository routerRepository;

    @GetMapping("/routers")
    public List<Router> getAllSwitches() {
        return routerRepository.findAll();
    }
}
