package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request;

import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import jakarta.validation.constraints.*;

public record CreateUser(
        @NotBlank(message = "{NOT.BLANK}")
        @Email
        String email,

        @NotBlank(message = "{NOT.BLANK}")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "The password must be at least 8 characters long, contain at least one uppercase letter, one digit, and one special character."
        )
        String password,

        @NotBlank
        @Size(min = 2, max = 100, message = "Must have between 2 to 100 characters")
        String name,

        @NotBlank
        @Pattern(
                regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$",
                message = "Please enter a valid CPF number in the format XXX.XXX.XXX-XX, where each X represents a digit. For example: 123.456.789-00."
        )
        String cpf,

        @NotBlank
        @Pattern(
                regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}-\\d$",
                message = "Please enter a valid RG number in the format XX.XXX.XXX-X, where each X represents a digit. For example: 12.345.678-9."
        )
        String rg,

        @NotBlank
        @Pattern(
                regexp = "^\\+\\d{1,3}\\s?\\(\\d{1,3}\\)\\s?\\d{3,4}-?\\d{4}$",
                message = "Please enter a valid cellphone number. Cellphone numbers should be in the format +XX-XXX-XXX-XXXX or XXX-XXX-XXXX and may include spaces, dashes, or periods. Make sure you have entered the correct number and try again."
        )
        String cellphone,

        @NotNull
        Address address,

        @NotNull
        UserPermission userPermission
) {
}
