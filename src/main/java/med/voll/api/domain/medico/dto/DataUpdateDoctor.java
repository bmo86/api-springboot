package med.voll.api.domain.medico.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.DataDirection;

public record DataUpdateDoctor(@NotNull Long id, String name, String document, DataDirection address) {
}
