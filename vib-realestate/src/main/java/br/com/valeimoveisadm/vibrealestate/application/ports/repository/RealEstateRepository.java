package br.com.valeimoveisadm.vibrealestate.application.ports.repository;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.RealEstate;

import java.util.List;

public interface RealEstateRepository {
    RealEstate save(RealEstate realEstate);

    RealEstate findById(Long id);

    List<RealEstate> findAll();

    void delete(RealEstate realEstate);
}
