package med.voll.api.domain.paciente.dto;

import med.voll.api.domain.address.DataDirection;

public record DataResponsePaciente(Long id, String name, String email, String phone, String docIdentify, DataDirection address) {
}
