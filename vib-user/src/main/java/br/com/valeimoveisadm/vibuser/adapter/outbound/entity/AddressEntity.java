package br.com.valeimoveisadm.vibuser.adapter.outbound.entity;

import br.com.valeimoveisadm.vibuser.application.core.enums.States;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressEntity {
    private String street;
    private Integer number;
    private String complement;
    private String neighborhood;
    private String city;
    private String postalCode;
    private States state;
    private String country;
}
