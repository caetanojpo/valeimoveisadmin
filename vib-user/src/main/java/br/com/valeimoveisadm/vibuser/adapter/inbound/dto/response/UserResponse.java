package br.com.valeimoveisadm.vibuser.adapter.inbound.dto.response;

import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String name,
        String cpf,
        String rg,
        String cellphone,
        Address address,
        UserPermission userPermission,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
