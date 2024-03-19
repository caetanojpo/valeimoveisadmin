package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request;

import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import jakarta.validation.constraints.*;

public record CreateUser(
        @NotBlank(message = "{NOT.BLANK}")
        @Email(message = "{EMAIL.PATTERN}")
        String email,

        @NotBlank(message = "{NOT.BLANK}")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "{PASSWORD.PATTERN}"
        )
        String password,

        @NotBlank
        @Size(min = 2, max = 100, message = "Must have between 2 to 100 characters")
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ\\s]+$", message = "{ALPHABETICAL.PATTERN}")
        String name,

        @NotBlank
        @Pattern(
                regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$",
                message = "{CPF.PATTERN}"
        )
        String cpf,

        @NotBlank
        @Pattern(
                regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}-\\d$",
                message = "{RG.PATTERN}"
        )
        String rg,

        @NotBlank
        @Pattern(
                regexp = "^\\+\\d{1,3}\\s?\\(\\d{1,3}\\)\\s?\\d{3,4}-?\\d{4}$",
                message = "{PHONE.PATTERN}"
        )
        String cellphone,

        @NotNull
        Address address,

        @NotNull
        UserPermission userPermission
) {
}
