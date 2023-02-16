package fr.barseghyan.test2itech.Service;

import fr.barseghyan.test2itech.DTO.MakeAppointmentRequest;
import fr.barseghyan.test2itech.Entity.Appointment;
import fr.barseghyan.test2itech.Entity.Commercial;
import fr.barseghyan.test2itech.Entity.CommercialsAppointment;
import fr.barseghyan.test2itech.Entity.User;
import fr.barseghyan.test2itech.Repository.AppointmentRepository;
import fr.barseghyan.test2itech.Repository.CommercialRepository;
import fr.barseghyan.test2itech.Repository.CommercialsAppointmentRepository;
import fr.barseghyan.test2itech.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final CommercialRepository commercialRepository;
    private final CommercialsAppointmentRepository commercialsAppointmentRepository;

    public UserService(UserRepository userRepository,
                       AppointmentRepository appointmentRepository, CommercialRepository commercialRepository,
                       CommercialsAppointmentRepository commercialsAppointmentRepository) {
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
        this.commercialRepository = commercialRepository;
        this.commercialsAppointmentRepository = commercialsAppointmentRepository;
    }

    public User GetConnectedUser(){
        return userRepository.findByEmail("achot@gmail.com").get();
    }


    public void MakeAppointment(MakeAppointmentRequest makeAppointmentRequest){
       Optional<Appointment> appointmentOptional = appointmentRepository.findCommercialsAppointmentByStartTime(makeAppointmentRequest.appointmentDateTime);
       Appointment appointment = new Appointment();

       if (appointmentOptional.isEmpty()){

           appointment = appointmentRepository.save(new Appointment(
                   makeAppointmentRequest.appointmentDateTime,
                   makeAppointmentRequest.appointmentDateTime,
                   makeAppointmentRequest.appointmentDateTime.plusHours(1)
           ));
       }

        Commercial commercial = commercialRepository.findById(makeAppointmentRequest.commercialId).get();

        commercial.getAppointments().add(appointment);
        commercialRepository.saveAndFlush(commercial);
    }
}
