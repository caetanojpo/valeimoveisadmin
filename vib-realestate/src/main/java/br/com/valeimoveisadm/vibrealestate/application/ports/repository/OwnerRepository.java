package br.com.valeimoveisadm.vibrealestate.application.ports.repository;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.Owner;

import java.util.List;

public interface OwnerRepository {

    Owner save(Owner owner);

    Owner findById(Long id);

    List<Owner> findAll();

    void delete(Owner owner);
}
