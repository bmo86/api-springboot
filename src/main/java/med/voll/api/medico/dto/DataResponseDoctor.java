package med.voll.api.medico.dto;

import med.voll.api.address.DataDirection;

public record DataResponseDoctor(Long id, String name, String email, String phone, String document, DataDirection address){
}
