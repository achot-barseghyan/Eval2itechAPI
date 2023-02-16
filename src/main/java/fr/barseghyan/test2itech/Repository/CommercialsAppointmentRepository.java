package fr.barseghyan.test2itech.Repository;

import fr.barseghyan.test2itech.Entity.CommercialsAppointment;
import fr.barseghyan.test2itech.Entity.CommercialsAppointmentId;
import fr.barseghyan.test2itech.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommercialsAppointmentRepository extends JpaRepository<CommercialsAppointment, CommercialsAppointmentId> {
    @Query("select c from CommercialsAppointment c where c.commercial.id = ?1 and c.appointment.Id = ?2")
    Optional<CommercialsAppointment> findByAllId(Long commercialId, Long appointmentId);
}