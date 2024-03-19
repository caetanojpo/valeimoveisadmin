package br.com.valeimoveisadm.vibrealestate.application.core.usecase.owner;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.Owner;
import br.com.valeimoveisadm.vibrealestate.application.ports.repository.OwnerRepository;

import java.util.List;

public class FindOwner {
    private final OwnerRepository repository;

    public FindOwner(OwnerRepository repository) {
        this.repository = repository;
    }

    public Owner executeById(Long id){
        return repository.findById(id);
    }

    public List<Owner> executeAll(){
        return repository.findAll();
    }
}
