package br.com.valeimoveisadm.vibrealestate.application.core.domain;

import java.util.Objects;

public class Complements {
    private Long id;
    private String description;

    public Complements(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Complements() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Complements that = (Complements) object;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
