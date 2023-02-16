package fr.barseghyan.test2itech.Repository;

import fr.barseghyan.test2itech.Entity.Appointment;
import fr.barseghyan.test2itech.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.email = ?1")
    Optional<User> findByEmail(String email);
}
