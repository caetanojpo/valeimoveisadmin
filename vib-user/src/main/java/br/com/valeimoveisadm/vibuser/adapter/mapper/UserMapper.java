package br.com.valeimoveisadm.vibuser.adapter.mapper;

import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request.CreateUser;
import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.UserResponse;
import br.com.valeimoveisadm.vibuser.adapter.outbound.persistence.entity.UserEntity;
import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(CreateUser createUser);
    User toUser(UserEntity userEntity);
    User toUser(UserDetails userDetails);

    List<User> toUserList(List<UserEntity> userEntityList);

    UserEntity toUserEntity(User user);

    UserResponse toUserResponse(UserEntity userEntity);
    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponseList(List<User> userList);
}
