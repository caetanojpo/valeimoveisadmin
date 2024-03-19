package br.com.valeimoveisadm.vibrealestate.application.ports.repository;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.Complements;

import java.util.List;

public interface ComplementsRepository {
    Complements save(Complements complements);

    Complements findById(Long id);

    List<Complements> findAll();

    void delete(Complements complements);
}
