package med.voll.api.paciente.dto;

import med.voll.api.paciente.Paciente;

public record ListsPaciente(Long id, String name, String email, String docIdentify) {
    public ListsPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getName(), paciente.getEmail(), paciente.getDoc_identify());
    }

}
