package fr.barseghyan.test2itech.Controller;

import fr.barseghyan.test2itech.DTO.MakeAppointmentRequest;
import fr.barseghyan.test2itech.Entity.User;
import fr.barseghyan.test2itech.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User GetConnectedUser(){
        return userService.GetConnectedUser();
    }

    @PostMapping("make-appointment")
    public void MakeAppointment(@RequestBody MakeAppointmentRequest makeAppointmentRequest){
        userService.MakeAppointment(makeAppointmentRequest);
    }
}
