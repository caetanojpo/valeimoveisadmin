package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response;

public record EventResponse(
        String id,
        UserResponse payload,
        String source,
        String status
) {
}
