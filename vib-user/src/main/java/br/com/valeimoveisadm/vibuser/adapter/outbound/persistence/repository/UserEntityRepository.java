package br.com.valeimoveisadm.vibuser.adapter.outbound.persistence.repository;

import br.com.valeimoveisadm.vibuser.adapter.mapper.UserMapper;
import br.com.valeimoveisadm.vibuser.adapter.outbound.persistence.entity.UserEntity;
import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.core.exceptions.ObjectNotFoundException;
import br.com.valeimoveisadm.vibuser.application.ports.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserEntityRepository implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private static final UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public User save(User user) {
        UserEntity userEntity = mapper.toUserEntity(user);
        UserEntity savedUser = jpaRepository.save(userEntity);
        return mapper.toUser(savedUser);
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = jpaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(UserEntity.class.getSimpleName(), id));

        return mapper.toUser(userEntity);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = jpaRepository.findbyEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException(UserEntity.class.getSimpleName(), email));

        return mapper.toUser(userEntity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntityList = jpaRepository.findAll();

        return mapper.toUserList(userEntityList);
    }
}
