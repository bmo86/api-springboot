package med.voll.api.domain.paciente.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.DataDirection;

public record DataRegisterPaciente(@NotBlank String name, @NotBlank String email,@NotBlank String phone,
                                   @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String docIdentify,
                                   @NotNull @Valid DataDirection address) {
}
