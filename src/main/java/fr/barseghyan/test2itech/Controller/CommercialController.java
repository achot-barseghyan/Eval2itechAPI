package fr.barseghyan.test2itech.Controller;

import fr.barseghyan.test2itech.Entity.Commercial;
import fr.barseghyan.test2itech.Service.CommercialService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/commercial")
@CrossOrigin
public class CommercialController {

    private final CommercialService commercialService;

    public CommercialController(CommercialService commercialService) {
        this.commercialService = commercialService;
    }

    @GetMapping
    public List<Commercial> getAllCommercials(){
        return commercialService.getAllCommercials();
    }
}
