package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DataRegisterDoctor;
import med.voll.api.medico.Medico;
import med.voll.api.medico.repo.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired //no es recomendable pq usar pruebas unitaras van a ver problemas
    private MedicoRepository medicoRepository;
    @PostMapping
    public void RegisterDoctor(@RequestBody @Valid DataRegisterDoctor data) {
        medicoRepository.save(new Medico(data));
    }

}
//patron DTO - Data Transform Object
//usar un objeto como intermediario para mapear informacion del cliente -> api
