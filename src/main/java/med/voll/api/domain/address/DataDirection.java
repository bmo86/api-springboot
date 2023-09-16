package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;

public record DataDirection(@NotBlank String street, @NotBlank String distrito, @NotBlank String city,
                            @NotBlank String number, @NotBlank String complement) {

}
