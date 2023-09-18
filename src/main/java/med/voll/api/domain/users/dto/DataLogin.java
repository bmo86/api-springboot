package med.voll.api.domain.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataLogin(
        String login,
        String password) {
}
