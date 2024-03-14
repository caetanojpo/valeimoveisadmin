package br.com.valeimoveisadm.vibuser.adapter.outbound.entity;

import br.com.valeimoveisadm.vibuser.application.core.domain.Address;
import br.com.valeimoveisadm.vibuser.application.core.enums.UserPermission;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "imob_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String cellphone;

    @Column(nullable = false)
    private UserPermission userPermission;

    @Embedded
    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private Boolean isActive;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
