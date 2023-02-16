package fr.barseghyan.test2itech.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommercialsAppointmentId implements Serializable {
    private static final long serialVersionUID = -8370428305364836312L;
    @NotNull
    @Column(name = "commercial_id", nullable = false)
    private Long commercialId;

    @NotNull
    @Column(name = "appointment_id", nullable = false)
    private Long appointmentId;

    public Long getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(Long commercialId) {
        this.commercialId = commercialId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CommercialsAppointmentId entity = (CommercialsAppointmentId) o;
        return Objects.equals(this.commercialId, entity.commercialId) && Objects.equals(
                this.appointmentId, entity.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commercialId, appointmentId);
    }

}