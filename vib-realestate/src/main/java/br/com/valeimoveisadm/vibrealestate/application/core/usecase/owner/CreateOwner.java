package br.com.valeimoveisadm.vibrealestate.application.core.usecase.owner;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.Owner;
import br.com.valeimoveisadm.vibrealestate.application.ports.repository.OwnerRepository;

public class CreateOwner {

    private final OwnerRepository repository;

    public CreateOwner(OwnerRepository repository) {
        this.repository = repository;
    }

    public Owner execute(Owner owner){
        return repository.save(owner);
    }
}
