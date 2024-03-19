package br.com.valeimoveisadm.vibrealestate.application.ports.repository;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.Address;

import java.util.List;

public interface AddressRepository {
    Address save(Address address);

    Address findById(Long id);

    List<Address> findAll();

    void delete(Address address);
}
