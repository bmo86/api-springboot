package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.dto.DataRegisterDoctor;
import med.voll.api.medico.dto.DataUpdateDoctor;
import med.voll.api.medico.dto.ListDoctors;
import med.voll.api.medico.Medico;
import med.voll.api.medico.repo.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired //no es recomendable pq usar pruebas unitaras van a ver problemas
    private MedicoRepository medicoRepository;

    @PostMapping
    public void RegisterDoctor(@RequestBody @Valid DataRegisterDoctor data) {
        medicoRepository.save(new Medico(data));
    }

    @GetMapping
    public Page<ListDoctors> listDoctor(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        //return medicoRepository.findAll(pageable).map(ListDoctors::new);
        return medicoRepository.findByActiveTrue(pageable).map(ListDoctors::new);

    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid DataUpdateDoctor data) {
        Medico med = medicoRepository.getReferenceById(data.id());
        med.updateDoc(data);
    }

    //DELETE logic
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable @Valid Long id) {
        Medico med = medicoRepository.getReferenceById(id);
        med.updateActive();
    }


// DELETE fisico - en db
/*  @DeleteMapping("/{id}") se eliminar directamente de la db
    public void deleteDoctor(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }
*/
}



//patron DTO - Data Transform Object
//usar un objeto como intermediario para mapear informacion del cliente -> api
