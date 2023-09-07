package med.voll.api.controller;

import med.voll.api.medico.DataRegisterDoctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void RegisterDoctor(@RequestBody DataRegisterDoctor data) {
        System.out.println("request send -> name : " + data);
    }

}
//patron DTO - Data Transform Object
//usar un objeto como intermediario para mapear informacion del cliente -> api
