package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.address.DataDirection;
import med.voll.api.domain.paciente.dto.DataResponsePaciente;
import med.voll.api.domain.paciente.dto.DataUpdatePaciente;
import med.voll.api.domain.paciente.dto.ListsPaciente;
import med.voll.api.domain.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import med.voll.api.domain.paciente.dto.DataRegisterPaciente;
import med.voll.api.domain.paciente.repo.PacienteRepository;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository PacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataResponsePaciente> RegisterPaciente(@RequestBody @Valid DataRegisterPaciente data, UriComponentsBuilder uriBuilder) {
        Paciente p = PacienteRepository.save(new Paciente(data));
        var response = new DataResponsePaciente(
                p.getId(),
                p.getName(),
                p.getEmail(),
                p.getPhone(),
                p.getDoc_identify(),
                new DataDirection(
                        p.getAddress().getStreet(),
                        p.getAddress().getDistrito(),
                        p.getAddress().getCity(),
                        String.valueOf(p.getAddress().getNumber()),
                        p.getAddress().getComplement()
                )
        );

        URI url = uriBuilder.path("/pacientes/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ListsPaciente>> listsPaciente(@PageableDefault(page = 0, size = 10, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(PacienteRepository.findByActiveTrue(pageable).map(ListsPaciente::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponsePaciente> getPaciente(@PathVariable @Valid Long id) {
        Paciente p = PacienteRepository.getReferenceById(id);
        var response = new DataResponsePaciente(
                p.getId(),
                p.getName(),
                p.getEmail(),
                p.getPhone(),
                p.getDoc_identify(),
                new DataDirection(
                        p.getAddress().getStreet(),
                        p.getAddress().getDistrito(),
                        p.getAddress().getCity(),
                        String.valueOf(p.getAddress().getNumber()),
                        p.getAddress().getComplement()
                )

        );
        return ResponseEntity.ok(response);

    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponsePaciente> updatePaciente(@RequestBody @Valid DataUpdatePaciente data) {
        var p = PacienteRepository.getReferenceById(data.id());

        var response = new DataResponsePaciente(
                p.getId(),
                p.getName(),
                p.getEmail(),
                p.getPhone(),
                p.getDoc_identify(),
                new DataDirection(
                        p.getAddress().getStreet(),
                        p.getAddress().getDistrito(),
                        p.getAddress().getCity(),
                        String.valueOf(p.getAddress().getNumber()),
                        p.getAddress().getComplement()
                )
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponsePaciente> deletePaciente(@PathVariable Long id) {
        var p = PacienteRepository.getReferenceById(id);
        p.updateActive();
        return ResponseEntity.ok().build();
    }


}
