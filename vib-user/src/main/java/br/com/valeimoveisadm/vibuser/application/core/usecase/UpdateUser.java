package br.com.valeimoveisadm.vibuser.application.core.usecase;

import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import br.com.valeimoveisadm.vibuser.application.ports.cryptography.EncryptPassword;
import br.com.valeimoveisadm.vibuser.application.ports.outbound.UserRepository;

public class UpdateUser {

    private final UserRepository repository;
    private final FindUser find;
    private final EncryptPassword encryptPassword;

    public UpdateUser(UserRepository repository, FindUser find, EncryptPassword encryptPassword) {
        this.repository = repository;
        this.find = find;
        this.encryptPassword = encryptPassword;
    }

    public User changeUserPermission(Long id, UserPermission newPermission){
        User userToUpdate = find.byId(id);
        userToUpdate.setUserPermission(newPermission);
        return repository.save(userToUpdate);
    }

    public User updateAddress(Long id, Address address){
        User userToUpdate = find.byId(id);
        userToUpdate.setAddress(address);
        return repository.save(userToUpdate);
    }

    public User changePassword(Long id, String newPassword){
        User userToUpdate = find.byId(id);
        String encryptedPassword = encryptPassword.enconde(newPassword);
        userToUpdate.setPassword(encryptedPassword);
        return repository.save(userToUpdate);
    }
}
