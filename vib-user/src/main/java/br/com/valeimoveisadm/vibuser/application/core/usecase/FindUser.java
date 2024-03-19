package br.com.valeimoveisadm.vibuser.application.core.usecase;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.ports.repository.UserRepository;

import java.util.List;

public class FindUser {

    private final UserRepository repository;

    public FindUser(UserRepository repository) {
        this.repository = repository;
    }

    public User byId(Long id) {
        return repository.findById(id);
    }

    public User byEmail(String email){
        return repository.findByEmail(email);
    }

    public List<User> all(){return repository.findAll();}
}
