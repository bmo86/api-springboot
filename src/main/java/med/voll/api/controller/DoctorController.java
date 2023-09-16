package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.address.DataDirection;
import med.voll.api.domain.medico.dto.DataRegisterDoctor;
import med.voll.api.domain.medico.dto.DataResponseDoctor;
import med.voll.api.domain.medico.dto.DataUpdateDoctor;
import med.voll.api.domain.medico.dto.ListDoctors;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.repo.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired //no es recomendable pq usar pruebas unitaras van a ver problemas
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DataResponseDoctor> RegisterDoctor(@RequestBody @Valid DataRegisterDoctor data, UriComponentsBuilder uriBuilder) {
        Medico medico = medicoRepository.save(new Medico(data));
        DataResponseDoctor response = new DataResponseDoctor(
                medico.getId(),
                medico.getName(),
                medico.getEmail(),
                medico.getPhone(),
                medico.getDocument(),
                new DataDirection(
                        medico.getAddress().getStreet(),
                        medico.getAddress().getDistrito(),
                        medico.getAddress().getCity(),
                        String.valueOf(medico.getAddress().getNumber()),
                        medico.getAddress().getComplement()));
        // Return 201 created
        // URL donde se puede acceder al recurso creado
        // GET https: localhost:8080/doctors/1
        URI url = uriBuilder.path("/doctors/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ListDoctors>> listDoctor(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        //return medicoRepository.findAll(pageable).map(ListDoctors::new);
        //return medicoRepository.findByActiveTrue(pageable).map(ListDoctors::new);
        return ResponseEntity.ok(medicoRepository.findByActiveTrue(pageable).map(ListDoctors::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseDoctor> getDoctor(@PathVariable @Valid Long id) {
        Medico med = medicoRepository.getReferenceById(id);
        var response = new DataResponseDoctor(
                med.getId(),
                med.getName(),
                med.getEmail(),
                med.getPhone(),
                med.getDocument(),
                new DataDirection(
                        med.getAddress().getStreet(),
                        med.getAddress().getDistrito(),
                        med.getAddress().getCity(),
                        String.valueOf(med.getAddress().getNumber()),
                        med.getAddress().getComplement()));
        return ResponseEntity.ok(response);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseDoctor> updateDoctor(@RequestBody @Valid DataUpdateDoctor data) {
        Medico med = medicoRepository.getReferenceById(data.id());
        med.updateDoc(data);
        return ResponseEntity.ok(new DataResponseDoctor(
                med.getId(),
                med.getName(),
                med.getEmail(),
                med.getPhone(),
                med.getDocument(),
                new DataDirection(
                        med.getAddress().getStreet(),
                        med.getAddress().getDistrito(),
                        med.getAddress().getCity(),
                        String.valueOf(med.getAddress().getNumber()),
                        med.getAddress().getComplement())));
    }

    //DELETE logic
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponseDoctor> deleteDoctor(@PathVariable @Valid Long id) {
        Medico med = medicoRepository.getReferenceById(id);
        med.updateActive();
        return ResponseEntity.ok().build();
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
