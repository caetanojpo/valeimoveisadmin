package br.com.valeimoveisadm.vibuser.application.core.usecase;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.core.exceptions.ObjectNotFoundException;
import br.com.valeimoveisadm.vibuser.application.ports.outbound.UserRepository;

public class FindUser {

    private final UserRepository repository;

    public FindUser(UserRepository repository) {
        this.repository = repository;
    }

    public User byId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(User.class.getSimpleName(), id));
    }

    public User byEmail(String email){
        return repository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException(User.class.getSimpleName(), email));
    }
}
