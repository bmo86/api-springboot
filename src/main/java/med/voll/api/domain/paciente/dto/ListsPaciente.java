package med.voll.api.domain.paciente.dto;

import med.voll.api.domain.paciente.Paciente;

public record ListsPaciente(Long id, String name, String email, String docIdentify) {
    public ListsPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getName(), paciente.getEmail(), paciente.getDoc_identify());
    }

}
