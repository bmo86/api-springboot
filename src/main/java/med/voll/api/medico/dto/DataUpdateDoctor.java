package med.voll.api.medico.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataDirection;

public record DataUpdateDoctor(@NotNull Long id, String name, String document, DataDirection address) {
}
