package br.com.valeimoveisadm.vibuser.application.core.usecase;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import br.com.valeimoveisadm.vibuser.application.ports.cryptography.EncryptPassword;
import br.com.valeimoveisadm.vibuser.application.ports.outbound.UserRepository;

public class CreateUser {

    private final UserRepository repository;
    private final EncryptPassword encryptPassword;


    public CreateUser(UserRepository repository, EncryptPassword encryptPassword) {
        this.repository = repository;
        this.encryptPassword = encryptPassword;
    }

    public User execute(User user){
        String encryptedPassword = encryptPassword.enconde(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setActive(true);
        return repository.save(user);
    }
}
