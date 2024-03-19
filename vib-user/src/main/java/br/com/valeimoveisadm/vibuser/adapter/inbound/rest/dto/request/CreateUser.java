package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request;

import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateUser(
        @NotBlank(message = "{NOT.BLANK}")
        @Email
        String email,

        @NotBlank(message = "{NOT.BLANK}")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "A Senha deve ter pelo menos 8 caracteres de comprimento, conter pelo menos uma letra maiúscula, um dígito e um caractere especial."
        )
        String password,

        @NotBlank
        String name,

        @NotBlank
        String cpf,

        @NotBlank
        String rg,

        @NotBlank
        String cellphone,

        @NotNull
        Address address,

        @NotNull
        UserPermission userPermission
) {
}
