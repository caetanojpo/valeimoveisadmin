package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request;

import br.com.valeimoveisadm.vibuser.application.core.enums.States;

public record ChangeAddress(
        String street,
        Integer number,
        String complement,
        String neighborhood,
        String city,
        String postalCode,
        States state,
        String country
) {
}
