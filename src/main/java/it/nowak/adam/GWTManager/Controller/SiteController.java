package it.nowak.adam.GWTManager.Controller;


        import it.nowak.adam.GWTManager.Model.Locations.SiteRepository;
        import it.nowak.adam.GWTManager.Model.Locations.Site;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;

    @GetMapping("/sites")
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }
}
