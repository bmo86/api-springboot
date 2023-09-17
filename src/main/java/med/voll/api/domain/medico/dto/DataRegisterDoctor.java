package med.voll.api.domain.medico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.DataDirection;
import med.voll.api.domain.medico.Especialidad;

public record DataRegisterDoctor(
        @NotBlank(message = "name is required") String name,
        @NotBlank(message = "email is required") @Email(message = "format email is invalid") String email,
        @NotBlank(message = "phone is required") @Pattern(regexp = "\\d{8}", message = "much characters") String phone,
        @NotBlank(message = "document is required") @Pattern(regexp = "\\d{4,6}", message = "much characters") String document,
        @NotNull(message = "especialidad is required") Especialidad espacialidad,
        @NotNull(message = "address is required") @Valid DataDirection address) {

}
