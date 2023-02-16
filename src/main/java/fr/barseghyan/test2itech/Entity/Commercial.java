package fr.barseghyan.test2itech.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "commercial")
@NoArgsConstructor
public class Commercial {

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
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String tel;

    @ManyToMany(
            cascade = {
                    CascadeType.ALL
            })
    @JoinTable(name = "commercials_appointments",
            joinColumns = { @JoinColumn(name = "commercial_id") },
            inverseJoinColumns = { @JoinColumn(name = "appointment_id") })
    private Set<Appointment> appointments;

    public Commercial(String name, String email, String tel) {
        this.name = name;
        this.email = email;
        this.tel = tel;
    }
}
