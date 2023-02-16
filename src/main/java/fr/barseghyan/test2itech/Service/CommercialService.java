package fr.barseghyan.test2itech.Service;

import fr.barseghyan.test2itech.Entity.Commercial;
import fr.barseghyan.test2itech.Repository.CommercialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommercialService {

    private final CommercialRepository commercialRepository;

    public CommercialService(CommercialRepository commercialRepository) {
        this.commercialRepository = commercialRepository;
    }

    public List<Commercial> getAllCommercials(){
        return commercialRepository.findAll();
    }
}
