package br.com.valeimoveisadm.vibuser.application.core.domain;

import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;

import java.util.Objects;

public class User {
    private Long id;
    private String email;
    private String password;
    private String cpf;
    private String rg;
    private String cellphone;
    private UserPermission userPermission;
    private Address address;
    private Boolean isActive;

    public User(Long id, String email, String password, String cpf, String rg, String cellphone, UserPermission userPermission, Address address, Boolean isActive) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
        this.cellphone = cellphone;
        this.userPermission = userPermission;
        this.address = address;
        this.isActive = isActive;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public UserPermission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
