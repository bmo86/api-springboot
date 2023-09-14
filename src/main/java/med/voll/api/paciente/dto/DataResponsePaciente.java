package med.voll.api.paciente.dto;

import med.voll.api.address.DataDirection;

public record DataResponsePaciente(Long id, String name, String email, String phone, String docIdentify, DataDirection address) {
}
