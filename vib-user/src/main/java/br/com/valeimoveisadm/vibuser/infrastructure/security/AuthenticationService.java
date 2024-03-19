package br.com.valeimoveisadm.vibuser.infrastructure.security;

import br.com.valeimoveisadm.vibuser.adapter.outbound.persistence.entity.UserEntity;
import br.com.valeimoveisadm.vibuser.adapter.outbound.persistence.repository.UserJpaRepository;
import br.com.valeimoveisadm.vibuser.application.core.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserJpaRepository jpaRepository;


    public UserEntity loadUserByUsername(String email) {
        return jpaRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException(UserEntity.class.getSimpleName(), email));
    }
}
