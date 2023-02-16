package fr.barseghyan.test2itech.Repository;

import fr.barseghyan.test2itech.Entity.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialRepository extends JpaRepository<Commercial, Long> {
}
