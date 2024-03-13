package br.com.valeimoveisadm.vibuser.application.ports.outbound;

import br.com.valeimoveisadm.vibuser.application.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}