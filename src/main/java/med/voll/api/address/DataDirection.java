package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;

public record DataDirection(@NotBlank String street, @NotBlank String distrito, @NotBlank String city,
                            @NotBlank String number, @NotBlank String complement) {

}
