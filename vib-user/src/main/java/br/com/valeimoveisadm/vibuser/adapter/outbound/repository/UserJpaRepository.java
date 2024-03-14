package br.com.valeimoveisadm.vibuser.adapter.outbound.repository;

import br.com.valeimoveisadm.vibuser.adapter.outbound.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findbyEmail(String email);
}
