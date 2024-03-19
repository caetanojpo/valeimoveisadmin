package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.controller;

import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request.ChangeAddress;
import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.request.CreateUser;
import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.UserResponse;
import br.com.valeimoveisadm.vibuser.adapter.mapper.AddressMapper;
import br.com.valeimoveisadm.vibuser.adapter.mapper.UserMapper;
import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.domain.User;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import br.com.valeimoveisadm.vibuser.application.core.usecase.FindUser;
import br.com.valeimoveisadm.vibuser.application.core.usecase.RemoveUser;
import br.com.valeimoveisadm.vibuser.application.core.usecase.UpdateUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final br.com.valeimoveisadm.vibuser.application.core.usecase.CreateUser create;
    private final FindUser find;
    private final UpdateUser update;
    private final RemoveUser remove;

    private static final UserMapper mapper = UserMapper.INSTANCE;
    private static final AddressMapper addressMapper = AddressMapper.INSTANCE;
    private static final String ROUTE = "/users/{id}";

    @GetMapping
    public ResponseEntity<List<UserResponse>> all(){
        List<User> userList = find.all();
        List<UserResponse> userResponseList =  mapper.toUserResponseList(userList);

        return ResponseEntity.ok(userResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> byId(@PathVariable("id") Long id){
        User foundUser = find.byId(id);
        UserResponse userResponse = mapper.toUserResponse(foundUser);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> byEmail(@PathVariable("email") String email){
        User foundUser = find.byEmail(email);
        UserResponse userResponse = mapper.toUserResponse(foundUser);

        return ResponseEntity.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid CreateUser createUser, UriComponentsBuilder uriBuilder){
        User toCreateData = mapper.toUser(createUser);

        User createdUser = create.execute(toCreateData);
        UserResponse response = mapper.toUserResponse(createdUser);

        URI uri = uriBuilder.path(ROUTE).buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PatchMapping("/permissions/{id}")
    public ResponseEntity<UserResponse> changeUserPermission(@PathVariable("id") Long id, @RequestBody UserPermission userPermission){
        User updatedUser = update.changeUserPermission(id, userPermission);

        UserResponse response = mapper.toUserResponse(updatedUser);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/address/{id}")
    public ResponseEntity<UserResponse> changeUserAddres(@PathVariable("id") Long id, @RequestBody @Valid ChangeAddress addressData){
        Address address = addressMapper.toAddress(addressData);
        User updatedUser = update.updateAddress(id, address);

        UserResponse response = mapper.toUserResponse(updatedUser);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/password/{id}")
    public ResponseEntity<Void> changePassword(@PathVariable("id") Long id, @RequestBody String password){
        update.changePassword(id, password);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        remove.execute(id);

        return ResponseEntity.noContent().build();
    }
}
