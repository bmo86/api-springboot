package med.voll.api.domain.paciente.dto;

import jakarta.validation.Valid;
import med.voll.api.domain.address.DataDirection;

public record DataUpdatePaciente(Long id, String name, String phone, @Valid DataDirection address) {
}
