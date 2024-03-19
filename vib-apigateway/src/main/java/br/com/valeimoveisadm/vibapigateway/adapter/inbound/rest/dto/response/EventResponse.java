package br.com.valeimoveisadm.vibrealestate.adapter.inbound.rest.dto.response;

public record EventResponse(
        String id,
        String payload,
        String source,
        String status
) {
}

