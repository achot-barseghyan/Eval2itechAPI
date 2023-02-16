package fr.barseghyan.test2itech.Service;

import fr.barseghyan.test2itech.Entity.Appointment;
import fr.barseghyan.test2itech.Repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }
}
