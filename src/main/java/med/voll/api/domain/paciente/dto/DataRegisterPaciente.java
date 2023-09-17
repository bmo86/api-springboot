package med.voll.api.domain.paciente.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.DataDirection;

public record DataRegisterPaciente(@NotBlank(message = "name is required") String name,
                                   @NotBlank(message = "email is required") @Email(message = "format email is invalid") String email,
                                   @NotBlank(message = "phone is required") String phone,
                                   @NotBlank(message = "docIdentify is required") @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "format invalid") String docIdentify,
                                   @NotNull(message = "address is required") @Valid DataDirection address) {
}
