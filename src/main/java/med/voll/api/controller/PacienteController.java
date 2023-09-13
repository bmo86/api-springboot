package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.dto.DataUpdatePaciente;
import med.voll.api.paciente.dto.ListsPaciente;
import med.voll.api.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import med.voll.api.paciente.dto.DataRegisterPaciente;
import med.voll.api.paciente.repo.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository PacienteRepository;

    @PostMapping
    @Transactional
    public void RegisterPaciente(@RequestBody @Valid DataRegisterPaciente data) {
        PacienteRepository.save(new Paciente(data));
    }

    @GetMapping
    public Page<ListsPaciente> listsPaciente(@PageableDefault(page = 0, size = 10, sort = "name") Pageable pageable) {
        return PacienteRepository.findByActiveTrue(pageable).map(ListsPaciente::new);
    }

    @GetMapping("/{id}")
    @Transactional
    public ListsPaciente listsPaciente(@PathVariable Long id) {
        return new ListsPaciente(PacienteRepository.getReferenceById(id));
    }

    @PutMapping
    @Transactional
    public void updatePaciente(@RequestBody @Valid DataUpdatePaciente data) {
        var p = PacienteRepository.getReferenceById(data.id());
        p.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePaciente(@PathVariable Long id) {
        var p = PacienteRepository.getReferenceById(id);
        p.updateActive();
    }


}
