package med.voll.api.domain.medico.dto;

import med.voll.api.domain.address.DataDirection;

public record DataResponseDoctor(Long id, String name, String email, String phone, String document, DataDirection address){
}
