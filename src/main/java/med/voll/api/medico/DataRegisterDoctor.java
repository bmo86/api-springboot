package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.DataDirection;

public record DataRegisterDoctor(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{8}") String phone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String document,
        @NotNull Especialidad espacialidad,
        @NotNull @Valid DataDirection address) {

}
