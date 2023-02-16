package fr.barseghyan.test2itech.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "commercials_appointments")
public class CommercialsAppointment {
    @EmbeddedId
    private CommercialsAppointmentId id;

    @MapsId("commercialId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commercial_id", nullable = false)
    private Commercial commercial;

    @MapsId("appointmentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @Column(nullable = true)
    private int userId;

    @Column(nullable = true)
    private String eventName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public CommercialsAppointmentId getId() {
        return id;
    }

    public void setId(CommercialsAppointmentId id) {
        this.id = id;
    }

    public Commercial getCommercial() {
        return commercial;
    }

    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}