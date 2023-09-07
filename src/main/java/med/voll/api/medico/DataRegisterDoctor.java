package med.voll.api.medico;

import med.voll.api.address.DataDirection;

public record DataRegisterDoctor(String name, String email, String document, Especialidad espacialidad, DataDirection address) {
}
