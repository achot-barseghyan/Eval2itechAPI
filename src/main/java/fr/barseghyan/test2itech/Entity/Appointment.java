package fr.barseghyan.test2itech.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "appointment")
@NoArgsConstructor
public class Appointment {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long Id;

    private LocalDateTime Day;
    private LocalDateTime StartTime;
    private LocalDateTime EndTime;

    @ManyToMany(mappedBy = "appointments",
            cascade = {
                    CascadeType.ALL
            })
    private Set<Commercial> commercials;

    public Appointment(LocalDateTime day, LocalDateTime startTime, LocalDateTime endTime) {
        Day = day;
        StartTime = startTime;
        EndTime = endTime;
    }
}
