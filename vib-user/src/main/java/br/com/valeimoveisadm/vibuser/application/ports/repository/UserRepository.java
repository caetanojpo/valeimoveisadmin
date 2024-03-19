package br.com.valeimoveisadm.vibuser.application.ports.repository;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();
}
