package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request;

import br.com.valeimoveisadm.vibuser.application.core.enums.States;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record ChangeAddress(
        @NotBlank(message = "Street is required")
        String street,

        @NotNull(message = "Number is required")
        @Positive(message = "Number must be positive")
        Integer number,

        String complement,

        @NotBlank(message = "Neighborhood is required")
        String neighborhood,

        @NotBlank(message = "City is required")
        String city,

        @Pattern(regexp = "\\d{5}-\\d{3}", message = "Invalid postal code format (XXXXX-XXX)")
        String postalCode,

        @NotNull(message = "State is required")
        States state,

        @NotBlank(message = "Country is required")
        String country
) {
}
