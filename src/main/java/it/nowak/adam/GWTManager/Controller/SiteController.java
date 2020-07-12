package it.nowak.adam.GWTManager.Controller;


import it.nowak.adam.GWTManager.Model.Locations.Site;
import it.nowak.adam.GWTManager.Model.Locations.SiteRepository;
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
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;

    @GetMapping("/sites")
    public List<it.nowak.adam.GWTManager.Model.Locations.Site> getAllSites() {
        return siteRepository.findAll();
    }
    @GetMapping("/sites/{id}")
    public ResponseEntity<it.nowak.adam.GWTManager.Model.Locations.Site> getSitesById(@PathVariable(value = "id") Long siteId) throws ResourceNotFoundException {
        it.nowak.adam.GWTManager.Model.Locations.Site site =
                siteRepository
                        .findById(siteId)
                        .orElseThrow(() -> new ResourceNotFoundException("Site not found on :: " + siteId));
        return ResponseEntity.ok().body(site);
    }

    @PostMapping("/sites")
    public Site createSite(@Valid @RequestBody Site site) { return siteRepository.save(site);}

    @PutMapping("/sites/{id}")
    public ResponseEntity<Site> updateSite(

            @PathVariable(value = "id") Long siteId, @Valid @RequestBody Site siteDetails)
            throws ResourceNotFoundException {
        Site site =
                siteRepository
                        .findById(siteId)
                        .orElseThrow(() -> new ResourceNotFoundException("Site not found on :: " + siteId));

        site.setName(site.getName());
        site.setBuildings(site.getBuildings());
        site.setUsers(site.getUsers());
        final Site updatedSwitch = siteRepository.save(site);
        return ResponseEntity.ok(updatedSwitch);
    }
    @DeleteMapping("/sites/{id}")
    public Map<String, Boolean> deleteSite(@PathVariable(value = "id") Long siteId) throws Exception {
        Site site =
                siteRepository
                        .findById(siteId)
                        .orElseThrow(() -> new ResourceNotFoundException("Site not found on :: " + siteId));
        siteRepository.delete(site);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
