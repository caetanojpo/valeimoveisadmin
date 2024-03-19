package br.com.valeimoveisadm.vibrealestate.application.core.domain;

import java.util.Objects;

public class Owner {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String cellphone;

    public Owner(Long id, String name, String cpf, String email, String cellphone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.cellphone = cellphone;
    }

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Owner owner = (Owner) object;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name) && Objects.equals(cpf, owner.cpf) && Objects.equals(email, owner.email) && Objects.equals(cellphone, owner.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, email);
    }
}
