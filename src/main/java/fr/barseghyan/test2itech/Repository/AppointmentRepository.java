package fr.barseghyan.test2itech.Repository;

import fr.barseghyan.test2itech.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = "select a from Appointment a where a.StartTime = ?1")
    Optional<Appointment> findCommercialsAppointmentByStartTime(LocalDateTime startTime);
}