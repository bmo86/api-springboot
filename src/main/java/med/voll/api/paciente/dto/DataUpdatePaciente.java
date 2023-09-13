package med.voll.api.paciente.dto;

import jakarta.validation.Valid;
import med.voll.api.address.DataDirection;

public record DataUpdatePaciente(Long id, String name, String phone, @Valid DataDirection address) {
}
