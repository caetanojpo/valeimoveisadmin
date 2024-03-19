package br.com.valeimoveisadm.vibuser.application.core.usecase;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.ports.repository.UserRepository;

public class RemoveUser {

    private final UserRepository repository;
    private final FindUser find;

    public RemoveUser(UserRepository repository, FindUser find) {
        this.repository = repository;
        this.find = find;
    }

    public void execute(Long id){
        User user = repository.findById(id);

        user.setActive(false);

        repository.save(user);
    }
}
